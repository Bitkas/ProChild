package com.DAI.ProChild.Chat;

import com.DAI.ProChild.ChatMessage;

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

@ServerEndpoint(value = "/chat/{email}")
public class ChatEndPoint {

    private Session session;
    private static final Set<ChatEndPoint> chatEndpoints = new CopyOnWriteArraySet<>();
    private static HashMap<String, String> users = new HashMap<>();

    @OnOpen
    public void onOpen(Session session, @PathParam("email") String email) throws IOException, EncodeException {
        this.session = session;
        chatEndpoints.add(this);
        users.put(session.getId(), email);

        ChatMessage chatMessage = new ChatMessage();
        chatMessage.setFrom(users.get(session.getId()));
        chatMessage.setContent("Connected!");
        broadcast(chatMessage);
    }

    @OnMessage
    public void onMessage(Session session, ChatMessage chatMessage) throws IOException, EncodeException {
        chatMessage.setFrom(users.get(session.getId()));
        broadcast(chatMessage);
    }

    @OnClose
    public void onClose(Session session) throws IOException, EncodeException {
        chatEndpoints.remove(this);
        ChatMessage chatMessage = new ChatMessage();
        chatMessage.setFrom(users.get(session.getId()));
        chatMessage.setContent("Disconnected!");
        broadcast(chatMessage);
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
