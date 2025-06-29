package com.example.user.service;

import com.example.user.model.User;
import com.example.user.repository.UserRepository;

public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String getUserNameById(Long id) {
        User user = userRepository.findById(id);
        return user != null ? user.getName() : "Unknown";
    }

    public int getUserCount() {
        return userRepository.findAll().size();
    }
}
