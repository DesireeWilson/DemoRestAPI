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
    void updateUserFirstName(Long id, @RequestBody String firstName) {
        User user = userService.findById(id);
        user.setFirstName(firstName);
        userService.save(user);
    }

    @PutMapping//update
    void updateUserLasttName(Long id, @RequestBody String lastName) {
        User user = userService.findById(id);
        user.setLastName(lastName);
        userService.save(user);
    }

    @PutMapping(path="/")//update
    void updateUserAge(Long id, @RequestBody int age) {
        User user = userService.findById(id);
        user.setAge(age);
        userService.save(user);
    }

    @DeleteMapping(path="/")//delete
    String deleteUser(@RequestBody User user) {
        return userService.deleteUser(user);
    }
}
