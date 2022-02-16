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

    @PostMapping//create
    String createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @GetMapping//retrieve
    User getRequest() {
        return new User("Desiree", "Wilson", 34);
    }

    @PutMapping//update
    void updateUser(Long id, @RequestBody User updateUser) {
        User existingUser = userService.findById(id);
        existingUser.setFirstName(updateUser.getFirstName());
        existingUser.setLastName(updateUser.getLastName());
        existingUser.setAge(updateUser.getAge());
        userService.save(existingUser);
    }

    @DeleteMapping(path="/")//delete
    String deleteUser(@RequestBody User user) {
        return userService.deleteUser(user);
    }
}
