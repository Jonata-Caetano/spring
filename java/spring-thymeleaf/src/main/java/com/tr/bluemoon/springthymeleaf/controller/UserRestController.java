package com.tr.bluemoon.springthymeleaf.controller;

import com.tr.bluemoon.springthymeleaf.model.Users;
import com.tr.bluemoon.springthymeleaf.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserRestController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<Users> getUsers() {
        return userRepository.findAll();
    }

    @PostMapping
    public String addUser(@RequestBody Users user) {
        userRepository.save(user);

        return "Ok";
    }
}
