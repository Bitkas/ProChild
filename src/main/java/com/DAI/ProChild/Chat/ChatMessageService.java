package com.DAI.ProChild.Chat;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ChatMessageService {

    private ChatMessageRepository chatMessageRepository;

    @Autowired
    public ChatMessageService(ChatMessageRepository chatMessageRepository) {
        this.chatMessageRepository = chatMessageRepository;
    }

    public boolean saveChatMessage(ChatMessage chatMessage) {
        this.chatMessageRepository.save(chatMessage);
        return true;
    }

    public List<ChatMessage> getAllChatMessages() {
        ArrayList<ChatMessage> chatMessages = new ArrayList((Collection) this.chatMessageRepository.findAll());
        return chatMessages;
    }
}
