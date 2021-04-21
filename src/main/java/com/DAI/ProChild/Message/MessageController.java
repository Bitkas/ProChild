package com.DAI.ProChild.Message;

import com.DAI.ProChild.Topic.Topic;
import com.DAI.ProChild.Topic.TopicService;
import com.DAI.ProChild.User.User;
import com.DAI.ProChild.User.UserService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class MessageController {
    private final MessageService messageService;
    private final UserService userService;
    private final TopicService topicService;
    private final Gson gson = new Gson();

    @Autowired
    public MessageController(MessageService messageService, UserService userService){
        this.messageService = messageService;
        this.topicService = topicService;
        this.userService = userService;
    }

    @GetMapping(path = "/Message/")
    public ResponseEntity<String> getAllUsers() {
        List<User> users = this.userService.GetAllUsers();
        return ResponseEntity.ok()
                .body(gson.toJson(users));
    }
    @RequestMapping(value = "/RegisterMessage", method = RequestMethod.POST)
    public ResponseEntity<String> registerMessage(@RequestBody boolean isURL, @RequestBody String message, @RequestBody String email, @RequestBody String title){
        Optional<User> user = this.userService.getUser(email);
        if(user.isPresent()){
            Optional<Message> messages = this.messageService.getMessage(idMessage);
            Optional<Topic> topics = this.topicService.getTopic(title);
            if(topics.isPresent()){
                Message newMessage = new Message(isURL, message);
                this.messageService.registerMessage(newMessage);
                return ResponseEntity.ok()
                        .body(gson.toJson(newMessage));
            }else{
                return ResponseEntity.ok()
                        .body(gson.toJson("Tópico não encontrado"));
            }
        }else{
            return ResponseEntity.ok()
                    .body(gson.toJson("User não Encontrado"));
        }
    }

    @RequestMapping(value = "/RegisterMessage", method = RequestMethod.DELETE)
    public ResponseEntity<String> registerMessage(@RequestBody boolean isURL, @RequestBody String message, @RequestBody String email, @RequestBody String title){
        Optional<User> user = this.userService.getUser(email);
        if(user.isPresent()){
            Optional<Message> messages = this.messageService.getMessage(idMessage);
            Optional<Topic> topics = this.topicService.getTopic(title);
            if(topics.isPresent()){
                this.messageService.deleteMessage(messages.get());
                return ResponseEntity.ok()
                        .body(gson.toJson(messages));
            }else{
                return ResponseEntity.ok()
                        .body(gson.toJson("Tópico não encontrado"));
            }
        }else{
            return ResponseEntity.ok()
                    .body(gson.toJson("User não Encontrado"));
        }
    }

}
