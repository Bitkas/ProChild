package com.DAI.ProChild.Topic;

import com.DAI.ProChild.User.User;
import com.DAI.ProChild.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class TopicController {
    private final TopicService topicService;
    private final UserService userService;

    @Autowired
    public TopicController(TopicService topicService, UserService userService) {
        this.topicService = topicService;
        this.userService = userService;
    }
    @GetMapping(path = "/Topic/")
    public List<Topic> getAllTopics() {
        System.out.print("getAll");
        return this.topicService.GetAllTopics();
    }

    @RequestMapping(path = "/RegisterTopic", method = RequestMethod.POST)
    public HttpStatus registerTopic(@RequestBody String title, @RequestBody String theme, @RequestBody String email){
        Optional<User> user = this.userService.getUser(email);
        if(user.isPresent()){
            Optional<Topic> topics = this.topicService.getTopic(title);
            if(topics.isPresent() ){
                return HttpStatus.CONFLICT;
                }else{
                Topic topic = new Topic(title, theme);
                this.topicService.registerTopic(topic);
                return HttpStatus.OK;
                }
         }else{
            return HttpStatus.NOT_FOUND;
        }
    }

    @RequestMapping (path = "/DeleteTopic", method = RequestMethod.DELETE)
    public HttpStatus deleteTopic(@RequestBody String title, @RequestBody String theme, @RequestBody String email){
        Optional<User> user = this.userService.getUser(email);
        if(user.isPresent()){
            Optional<Topic> topics = this.topicService.getTopic(title);
            if (topics.isPresent()){

                this.topicService.deleteTopic(topic);
                return HttpStatus.OK;
            }else{
                return HttpStatus.CONFLICT;
            }
        }else{
            return HttpStatus.NOT_FOUND;
        }
    }





}



