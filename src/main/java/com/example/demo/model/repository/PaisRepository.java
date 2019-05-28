package com.example.demo.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.jpa.Pais;

public interface PaisRepository extends JpaRepository<Pais, Long> {

}
