package com.example.demo.services;

import com.example.demo.model.User;
import org.springframework.data.domain.Page;


public interface UserService {
    Page<User> getAllUsers(int page, int size);
    String createUser(User user);
    boolean deleteUser(User user);
    User findById(Long id);
    User findByEmailAddress(String emailAddress);
    void save(User user);
    boolean userExists(User user);
}
