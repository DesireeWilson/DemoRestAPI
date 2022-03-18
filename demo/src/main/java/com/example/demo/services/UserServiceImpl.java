package com.example.demo.services;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    public UserRepository userRepository;

    @Override
    public Page<User> getAllUsers(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return userRepository.findAll(pageable);
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
        if(!userRepository.findById(user.getId()).isPresent()) {
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
