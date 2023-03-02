package com.example.projet1springboot.repositories;

import com.example.projet1springboot.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

 }
