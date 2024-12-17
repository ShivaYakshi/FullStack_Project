package com.example.MobileShop.service.Impl;

import com.example.MobileShop.model.User;
import com.example.MobileShop.repository.UserRepository;
import com.example.MobileShop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User registerUser(User user) {
        return userRepository.save(user); 
    }

    @Override
    public Optional<User> getUserById(String id) {
        return userRepository.findById(id); 
    }

    @Override
    public Optional<User> getUserByUsername(String username) {
        return userRepository.findAll().stream()
                .filter(user -> user.getUsername().equals(username))
                .findFirst();
    }

    @Override
    public boolean loginUser(String username, String password) {
        
        return userRepository.findAll().stream()
                .anyMatch(user -> user.getUsername().equals(username) && user.getPassword().equals(password));
    }
}
