package com.DAI.ProChild.Chat;

import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

import com.google.gson.Gson;

public class ChatMesssageDecoder implements Decoder.Text<ChatMessage> {
    private static Gson gson = new Gson();

    @Override
    public ChatMessage decode(String s) throws DecodeException {
        ChatMessage chatMessage = gson.fromJson(s, ChatMessage.class);
        return chatMessage;
    }

    @Override
    public boolean willDecode(String s) {
        return (s != null);
    }

    @Override
    public void init(EndpointConfig endpointConfig) {

    }

    @Override
    public void destroy() {

    }
}
