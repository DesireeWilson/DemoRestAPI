package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping(path="api/v1/users")
public class UserController {

    @Autowired
    public UserService userService;

    @PostMapping
    ResponseEntity<String> createUser(@Valid @RequestBody User user) {
        String body = userService.userExists(user) ? "Awesome! User already exists!" : "Great! User created!";
        HttpHeaders header = new HttpHeaders();
        header.add("desc", "Creating User!");
        userService.createUser(user);
        return new ResponseEntity<>(body, header, HttpStatus.OK);
    }

    @GetMapping
    Page<User> getAllUsers(@RequestParam(value="page", defaultValue = "0") int page,
                           @RequestParam(value="size", defaultValue = "3") int size) {
        return userService.getAllUsers(page, size);
    }

    @GetMapping(path="id/{id}")
    ResponseEntity<User> getUser(@PathVariable Long id) {
        User user = userService.findById(id);
        HttpHeaders header = new HttpHeaders();
        header.add("desc", "Retrieving user by ID");
        return ResponseEntity.status(HttpStatus.OK).headers(header).body(user);
    }

    @GetMapping(path="/emailAddress/{emailAddress}")
    ResponseEntity<User> getUserByEmailAddress(@PathVariable String emailAddress) {
        User user = userService.findByEmailAddress(emailAddress);
        HttpHeaders header = new HttpHeaders();
        header.add("desc", "Retrieving user by email address");
        return ResponseEntity.status(HttpStatus.OK).headers(header).body(user);
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
    ResponseEntity<String> deleteUser(@RequestBody Long id) {
        User user = userService.findById(id);
        String body = userService.deleteUser(user) ? "Successfully user deleted" : "Oh no! Something went wrong! :(";
        HttpHeaders header = new HttpHeaders();
        header.add("desc", "Deleting user by ID");
        return new ResponseEntity<>(body, header, HttpStatus.OK);
    }
}
