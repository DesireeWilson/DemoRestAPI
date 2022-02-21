package com.example.demo.services;

import com.example.demo.model.User;

import java.util.List;


public interface UserService {
    List<User> getAllUsers();
    String createUser(User user);
    boolean deleteUser(User user);
    User findById(Long id);
    User findByEmailAddress(String emailAddress);
    void save(User user);
    boolean userExists(User user);
}
