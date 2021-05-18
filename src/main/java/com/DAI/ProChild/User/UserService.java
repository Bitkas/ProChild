package com.DAI.ProChild.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class UserService {

    @Autowired
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> GetAllUsers() {
        return this.userRepository.findAll();
    }

    public Optional<User> getUser(String email) {
        Optional<User> user = this.userRepository.findById(email);
        return user;
    }

    public void registerUser(User user) {
        this.userRepository.save(user);
    }

    public void updateUser(User user) {
        this.userRepository.save(user);
    }



}
