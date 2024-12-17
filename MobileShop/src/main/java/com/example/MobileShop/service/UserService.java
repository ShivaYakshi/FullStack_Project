package com.example.MobileShop.service;

import com.example.MobileShop.model.User;

import java.util.Optional;

public interface UserService {
    User registerUser(User user);
    Optional<User> getUserById(String id);
    Optional<User> getUserByUsername(String username);
    boolean loginUser(String username, String password);
}
