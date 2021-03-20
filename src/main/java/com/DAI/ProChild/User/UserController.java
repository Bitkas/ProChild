package com.DAI.ProChild.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController

public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping(path = "/User/")
    public List<User> getAllUsers() {
        System.out.print("getAll");
        return this.userService.GetAllUsers();

    }

    @RequestMapping(value = "/User/{email}/", method = RequestMethod.GET)
    public String getUser(@PathVariable String email) {
        Optional<User> user = this.userService.getUser(email);
        if(user.isPresent()) {
            return user.get().getEmail();
        } else {
            return "User não Encontrado";
        }
    }
}
