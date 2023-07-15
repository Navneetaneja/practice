package com.example.practice.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.practice.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    
}
