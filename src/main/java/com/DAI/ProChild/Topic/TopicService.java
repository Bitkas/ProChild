package com.DAI.ProChild.Topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import java.util.HashSet;
import java.util.Set;

public class TopicService {
    private final TopicRepository topicRepository;

    @Autowired
    public TopicService(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }

    public Set<Topic> getAllTopics() {
        return new HashSet<>(this.topicRepository.findAll());
    }
}
