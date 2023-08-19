package com.example.practice.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.practice.entity.User;
import com.example.practice.repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public boolean saveUser(User user) {
        if(null != user.getEmail()){
            if(userRepository.existsByEmail(user.getEmail())){
                return false;
            }
            userRepository.save(user);
            return true;
        }
        return false;
    }

    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    
}
