package com.DAI.ProChild.Message;

import com.DAI.ProChild.Topic.Topic;
import com.DAI.ProChild.Topic.TopicService;
import com.DAI.ProChild.User.User;
import com.DAI.ProChild.User.UserService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public MessageController(MessageService messageService, UserService userService, TopicService topicService){
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
        Long start = System.currentTimeMillis();
        Optional<User> user = this.userService.getUser(email);
        if(user.isPresent()) {
            Optional<Topic> topics = this.topicService.getTopic(title);
            if (topics.isPresent()) {
                Message newMessage = new Message(isURL, message);
                this.messageService.registerMessage(newMessage);
                Long end = System.currentTimeMillis();
                Long time = end - start;
                String Time = gson.toJson(time);
                return ResponseEntity.ok()
                        .body(Time);

            } else {
                return ResponseEntity.badRequest()
                        .body("");
            }
        }else{
            return ResponseEntity.badRequest().body("");

        }
    }

    @RequestMapping(value = "/RegisterMessage", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteMessage(@RequestBody Integer idMessage, @RequestBody boolean isAdmin){
        if(isAdmin){
            Optional<Message> message = this.messageService.getMessage(idMessage);
                this.messageService.deleteMessage(message.get());
                return ResponseEntity.ok()
                        .body(gson.toJson(message));

        }else{
            return ResponseEntity.badRequest()
                    .body(gson.toJson("User n??o ?? o Admin!"));
        }
    }
}
