package com.example.demo.services;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    public UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public String createUser(User user) {
        if (!userExists(user)) {
            userRepository.save(user);
            return "User was created";
        }
        return "User already exists";
    }

    @Override
    public boolean deleteUser(User user) {
        userRepository.delete(user);
        if(userRepository.findById(user.getId()) == null) {
            System.out.println("User was deleted");
            return true;
        } else {
            System.out.println("Oh no! Something went wrong!");
            return false;
        }
    }

    @Override
    public User findById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.get();
    }

    @Override
    public User findByEmailAddress(String emailAddress) {
        return userRepository.findByEmailAddress(emailAddress);
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public boolean userExists(User user) {
        User searchUserEmail = findByEmailAddress(user.getEmailAddress());
        return !Objects.isNull(searchUserEmail);
    }
}
