package com.example.practice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.practice.entity.User;
import com.example.practice.service.UserService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("user")
public class UserController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<HttpStatus> saveUser(@RequestBody User user){
        return userService.saveUser(user)
        ? ResponseEntity.ok().build()
        : ResponseEntity.badRequest().build();
    }

    @GetMapping
    public ResponseEntity<User> getUserByEmail(@RequestParam String email){
        return userService.getUserByEmail(email)
        .map(ResponseEntity::ok)
        .orElseGet(()->ResponseEntity.noContent().build());
    }
}
