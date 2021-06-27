package com.DAI.ProChild.Chat;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


import javax.websocket.server.ServerEndpoint;
import javax.websocket.server.PathParam;
import javax.websocket.EncodeException;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import java.io.IOException;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

@ServerEndpoint(value = "/chat{email}", decoders = ChatMesssageDecoder.class, encoders = ChatMesssageEncoder.class)
@Controller
public class ChatEndPoint {
    private Session session;
    private static final Set<ChatEndPoint> chatEndpoints = new CopyOnWriteArraySet<>();
    private static HashMap<String, String> users = new HashMap<>();
    @Autowired
    private ChatMessageService chatMessageService;

    @Autowired
    public ChatEndPoint() {
        System.out.println("Inside web socket Constructor!");
    }
    @OnOpen
    public void onOpen(Session session, @PathParam("email") String email) throws IOException, EncodeException {
        this.session = session;
        chatEndpoints.add(this);
        users.put(session.getId(), email);
    }

    @OnMessage
    public void onMessage(Session session, ChatMessage chatMessage) throws IOException, EncodeException {
        chatMessage.setFrom(users.get(session.getId()));
        System.out.println(chatMessage.getContent());
        this.chatMessageService.saveChatMessage(chatMessage);
        broadcast(chatMessage);
    }

    @OnClose
    public void onClose(Session session) throws IOException, EncodeException {
        chatEndpoints.remove(this);
    }

    @OnError
    public void onError(Session session, Throwable throwable) {
        try {
            session.close();
        } catch (IOException exception) {
            exception.printStackTrace();
        } catch (Throwable throwable1) {
            throwable.fillInStackTrace();
        }

    }

    private static void broadcast(ChatMessage chatMessage) throws IOException, EncodeException {
        chatEndpoints.forEach(chatEndPoint -> {
            synchronized (chatEndPoint) {
                try {
                    chatEndPoint.session.getBasicRemote()
                            .sendObject(chatMessage);
                } catch (IOException | EncodeException exception) {
                    exception.printStackTrace();
                }
            }
        });
    }
}
