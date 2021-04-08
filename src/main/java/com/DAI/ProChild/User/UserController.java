package com.DAI.ProChild.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    @RequestMapping(value = "/RegisterUser", method = RequestMethod.POST)
    public HttpStatus registerUser(@RequestBody String name, @RequestBody String email, @RequestBody String kinship, @RequestBody String password, @RequestBody int contacto) {
        Optional<User> user = this.userService.getUser(email);
        if (user.isPresent()) {
            return HttpStatus.CONFLICT;
        } else {
            User newUser = new User(name, email, kinship, password, contacto);
            this.userService.registerUser(newUser);
            return HttpStatus.OK;
        }
    }

    @RequestMapping(value = "/test/", method = RequestMethod.GET)
    public String teste() {
        return "docker Worked!!!!!";
    }

}
