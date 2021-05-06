package com.DAI.ProChild.Message;

import com.DAI.ProChild.Topic.Topic;
import com.DAI.ProChild.Topic.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class MessageService {
    private final MessageRepository messageRepository;

    @Autowired
    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public List<Message> GetAllMessage(){
        return this.messageRepository.findAll();
    }


    public Optional<Message> getMessage(Integer idMessage) {
        Optional<Message> message = this.messageRepository.findById(idMessage);
        return message;
    }


    public void registerMessage(Message message){ this.messageRepository.save(message); }

    public void deleteMessage(Message message){
        this.messageRepository.delete(message);
    }
}


