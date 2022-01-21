package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="api/v1/user")
public class UserController {

    @Autowired
    public UserService userService;

    @GetMapping
    User getRequest() {
        return new User("Desiree", "Wilson", 34);
    }

    @PostMapping
    String createUser(@RequestBody User user) {
        return userService.createUser(user);
    }


}
