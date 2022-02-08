package com.example.demo.services;

import com.example.demo.model.User;

public interface UserService {

    String createUser(User user);
    String deleteUser(User user);
    User findById(long id);
    void save(User user);
}
