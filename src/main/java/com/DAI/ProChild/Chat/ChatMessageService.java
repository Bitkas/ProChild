package com.DAI.ProChild.Chat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service("chatMessageService")
public class ChatMessageService {

    private ChatMessageRepository chatMessageRepository;

    @Autowired
    public ChatMessageService(ChatMessageRepository chatMessageRepository) {
        this.chatMessageRepository = chatMessageRepository;
    }

    public ChatMessage saveChatMessage(ChatMessage chatMessage) {
         return this.chatMessageRepository.save(chatMessage);
    }

    public List<ChatMessage> getAllChatMessages() {
        ArrayList<ChatMessage> chatMessages = new ArrayList((Collection) this.chatMessageRepository.findAll());
        return chatMessages;
    }
}
