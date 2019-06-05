package com.example.demo.model.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.jpa.User;

@Transactional
public interface UserRepository extends JpaRepository<User, Long> {

    User findByLogin(String username);
}
