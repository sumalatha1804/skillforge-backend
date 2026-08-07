package com.skillforge.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillforge.entity.User;
import com.skillforge.repository.UserRepository;

@Service
public class ProfileService {

    @Autowired
    private UserRepository userRepository;

    public User getProfile(Long id) {
        return userRepository.findById(id).orElse(null);
    }
}