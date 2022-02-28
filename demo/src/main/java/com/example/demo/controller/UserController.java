package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping(path="api/v1/users")
public class UserController {

    @Autowired
    public UserService userService;

    @PostMapping
    String createUser(@Valid @RequestBody User user) {
        return userService.createUser(user);
    }

    @GetMapping
    List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping(path="id/{id}")
    User getUser(@PathVariable Long id) {
        return userService.findById(id);
    }

    @GetMapping(path="/emailAddress/{emailAddress}")
    User getUserByEmailAddress(@PathVariable String emailAddress) {
        return userService.findByEmailAddress(emailAddress);
    }

    @PutMapping
    void updateUser(Long id, @RequestBody User updateUser) {
        User existingUser = userService.findById(id);
        existingUser.setFirstName(updateUser.getFirstName());
        existingUser.setLastName(updateUser.getLastName());
        existingUser.setAge(updateUser.getAge());
        existingUser.setEmailAddress(updateUser.getEmailAddress());
        userService.save(existingUser);
    }

    @DeleteMapping
    boolean deleteUser(@RequestBody Long id) {
        User user = userService.findById(id);
        return userService.deleteUser(user);
    }


}
