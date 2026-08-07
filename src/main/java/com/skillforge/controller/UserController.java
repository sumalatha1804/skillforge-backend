package com.skillforge.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.skillforge.entity.User;
import com.skillforge.service.UserService;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserService userService;

    // Register User
    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        return userService.registerUser(user);
    }

    // Login User
    @PostMapping("/login")
    public User loginUser(@RequestBody User user) {

        User loginUser = userService.loginUser(
                user.getEmail(),
                user.getPassword());

        if (loginUser == null) {
            throw new RuntimeException("Invalid Email or Password");
        }

        return loginUser;
    }

    // Get All Users
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    // Search Users
    @GetMapping("/search/{name}")
    public List<User> searchUsers(@PathVariable String name) {
        return userService.searchUsers(name);
    }

    // Get User By Id
    @GetMapping("/id/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    // Update User
    @PutMapping("/update/{id}")
    public User updateUser(@PathVariable Long id,
                           @RequestBody User user) {
        return userService.updateUser(id, user);
    }

    // Delete User
    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return "User Deleted Successfully";
    }

    // User Count
    @GetMapping("/count")
    public Long getUserCount() {
        return userService.getUserCount();
    }

    // Test
    @GetMapping("/test")
    public String test() {
        return "User Controller Working";
    }

}