package com.example.demo.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.jpa.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
}
