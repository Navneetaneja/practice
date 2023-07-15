package com.example.practice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.practice.entity.User;
import com.example.practice.repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    
}
