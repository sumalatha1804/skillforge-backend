package com.skillforge.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillforge.dto.LoginRequest;
import com.skillforge.dto.LoginResponse;
import com.skillforge.entity.User;
import com.skillforge.repository.UserRepository;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    public LoginResponse login(LoginRequest request) {

        Optional<User> optionalUser =
                userRepository.findByEmail(request.getEmail());

        if (optionalUser.isPresent()) {

            User user = optionalUser.get();

            if (user.getPassword().equals(request.getPassword())) {
                return new LoginResponse("Login Successful", true);
            }
        }
        return new LoginResponse("Invalid Email or Password", false);
    }
}