package com.example.demo.services;

import com.example.demo.model.User;

import java.util.List;


public interface UserService {
    List<User> getAllUsers();
    String createUser(User user);
    String deleteUser(User user);
    User findById(Long id);
    void save(User user);
}
