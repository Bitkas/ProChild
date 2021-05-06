package com.DAI.ProChild.Topic;
import com.DAI.ProChild.User.User;
import com.DAI.ProChild.User.UserService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;
@RestController
public class TopicController {
    private final TopicService topicService;
    private final UserService userService;
    private final Gson gson = new Gson();
    @Autowired
    public TopicController(TopicService topicService, UserService userService) {
        this.topicService = topicService;
        this.userService = userService;
    }
    @GetMapping(path = "/Topic/")
    public ResponseEntity<String> getAllUsers() {
        List<User> users = this.userService.GetAllUsers();
        return ResponseEntity.ok()
                .body(gson.toJson(users));
    }
    @RequestMapping(value = "/RegisterTopic", method = RequestMethod.POST)
    public ResponseEntity<String> registerTopic(@RequestBody String title, @RequestBody String theme, @RequestBody String email){
        Optional<User> user = this.userService.getUser(email);
        if(user.isPresent()){
            Optional<Topic> topics = this.topicService.getTopic(title);
            if(topics.isPresent() ){
                return ResponseEntity.ok()
                        .body(gson.toJson( "Topico já existe!"));
                }else{
                Topic newTopic = new Topic(title, theme);
                this.topicService.registerTopic(newTopic);
                return ResponseEntity.ok()
                        .body(gson.toJson(newTopic));
                }
         }else{
            return ResponseEntity.ok()
                    .body(gson.toJson("User não Encontrado"));
        }
    }
    @RequestMapping (value = "/DeleteTopic", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteTopic(@RequestBody String title, @RequestBody String theme, @RequestBody String email){
        Optional<User> user = this.userService.getUser(email);
        if(user.isPresent()){
            Optional<Topic> topics = this.topicService.getTopic(title);
            if (topics.isPresent()){
                this.topicService.deleteTopic(topics.get());
                return ResponseEntity.ok()
                        .body(gson.toJson(topics));
            }else{
                return ResponseEntity.ok()
                        .body(gson.toJson("Tópico não Encontrado"));
            }
        }else{
            return ResponseEntity.ok()
                    .body(gson.toJson("User não Encontrado"));
        }
    }
}



