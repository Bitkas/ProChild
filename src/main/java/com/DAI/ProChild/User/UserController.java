package com.DAI.ProChild.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
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
    public ResponseEntity<String> registerUser(String email, String name, int cellphone, String kinship, String password) {
            Optional<User> user = this.userService.getUser(email);
            if(user.isPresent()) {
                return ResponseEntity.badRequest()
                        .body(gson.toJson("User already exists!"));
            } else {
                User user1 = new User(name, email, kinship, password,cellphone);
                this.userService.registerUser(user1);
                return ResponseEntity.ok()
                        .body(gson.toJson("user"));
            }
    }

    @GetMapping(path = "/LoggedInUser/")
    public String getUserLogado() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getPrincipal().toString();
    }

}
