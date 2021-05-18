package com.DAI.ProChild.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.google.gson.Gson;

import java.util.List;
import java.util.Optional;
@RestController
public class UserController {
    private final UserService userService;
    private final Gson gson = new Gson();

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping(path = "/User/")
    public ResponseEntity<String> getAllUsers() {
        List<User> users = this.userService.GetAllUsers();
        return ResponseEntity.ok()
                .body(gson.toJson(users));
    }
    @RequestMapping(path = "/User/{email}/", method = RequestMethod.GET)
    public ResponseEntity<String> getUser(@PathVariable String email) {
        Optional<User> user = this.userService.getUser(email);
        if(user.isPresent()) {
            return ResponseEntity.ok()
            .body(gson.toJson(user.get().getEmail()));
        } else {
            return ResponseEntity.ok()
                    .body(gson.toJson("User não Encontrado"));
        }}
    @RequestMapping(path = "/RegisterUser/", method = RequestMethod.POST)
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        Optional<User> user1 = this.userService.getUser(user.getEmail());
        if (user1.isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body(gson.toJson("Utilizador já existe!"));
        } else {
            this.userService.registerUser(user);
            return ResponseEntity.ok()
                    .body(gson.toJson(user));
        }
    }


}
