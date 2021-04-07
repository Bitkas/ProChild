package com.DAI.ProChild.Chat;

import com.DAI.ProChild.ChatMessage;
import com.google.gson.Gson;

import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;
import javax.websocket.EncodeException;

public class ChatMesssageEncoder implements Encoder.Text<ChatMessage> {

    private static Gson gson = new Gson();

    @Override
    public String encode(ChatMessage chatMessage) throws EncodeException {
        String json = gson.toJson(chatMessage);
        return  json;
    }

    @Override
    public void init(EndpointConfig endpointConfig) {

    }

    @Override
    public void destroy() {

    }
}
