package com.skillforge.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skillforge.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // Find User by Email
    Optional<User> findByEmail(String email);

    // Login
    Optional<User> findByEmailAndPassword(String email, String password);

    // Search User by Full Name
    List<User> findByFullNameContainingIgnoreCase(String fullName);

}