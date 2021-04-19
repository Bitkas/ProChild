package com.DAI.ProChild.Topic;

import com.DAI.ProChild.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
@Service
public class TopicService {
    private final TopicRepository topicRepository;

    @Autowired
    public TopicService(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }

    public List<Topic> GetAllTopics(){
      return this.topicRepository.findAll();
    }


    public Optional<Topic> getTopic(String title) {

        Optional<Topic> topic = this.topicRepository.findById(title);
        return topic;
    }


    public void registerTopic(Topic topic){
        this.topicRepository.save(topic);
        //return topic;
    }
}
