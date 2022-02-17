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

    @PostMapping
    String createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @GetMapping
    User getRequest() {
        return new User("Desiree", "Wilson", 34);
    }

    @PutMapping
    void updateUser(Long id, @RequestBody User updateUser) {
        User existingUser = userService.findById(id);
        existingUser.setFirstName(updateUser.getFirstName());
        existingUser.setLastName(updateUser.getLastName());
        existingUser.setAge(updateUser.getAge());
        userService.save(existingUser);
    }

    @DeleteMapping
    String deleteUser(@RequestBody Long id) {
        User user = userService.findById(id);
        return userService.deleteUser(user);
    }
}
