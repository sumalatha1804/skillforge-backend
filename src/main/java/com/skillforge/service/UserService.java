package com.skillforge.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillforge.entity.Student;
import com.skillforge.entity.User;
import com.skillforge.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private StudentService studentService;

    // ===========================
    // Register User
    // ===========================
    public User registerUser(User user) {

        Optional<User> existingUser = userRepository.findByEmail(user.getEmail());

        if (existingUser.isPresent()) {
            throw new RuntimeException("Email already exists");
        }

        // Save User
        User savedUser = userRepository.save(user);

        // Save Student Automatically
        Student student = new Student();
        student.setFullName(savedUser.getFullName());
        student.setEmail(savedUser.getEmail());
        student.setPhone(savedUser.getPhone());
        student.setCourse(savedUser.getCourse());

       
        studentService.updateStudent(student.getId(), student);

        return savedUser;
    }

    // ===========================
    // Login User
    // ===========================
    public User loginUser(String email, String password) {

        Optional<User> optionalUser = userRepository.findByEmail(email);

        if (optionalUser.isPresent()) {

            User dbUser = optionalUser.get();

            if (dbUser.getPassword().equals(password)) {
                return dbUser;
            }
        }

        return null;
    }

    // ===========================
    // Get All Users
    // ===========================
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // ===========================
    // Get User By Id
    // ===========================
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    // ===========================
    // Search Users
    // ===========================
    public List<User> searchUsers(String fullName) {
        return userRepository.findByFullNameContainingIgnoreCase(fullName);
    }

    // ===========================
    // Update User
    // ===========================
    public User updateUser(Long id, User user) {

        Optional<User> optionalUser = userRepository.findById(id);

        if (optionalUser.isPresent()) {

            User existingUser = optionalUser.get();

            existingUser.setFullName(user.getFullName());
            existingUser.setEmail(user.getEmail());
            existingUser.setPassword(user.getPassword());
            existingUser.setPhone(user.getPhone());
            existingUser.setCourse(user.getCourse());
            existingUser.setRole(user.getRole());

            // Save Updated User
            User updatedUser = userRepository.save(existingUser);

            // Update Student Table
            Student student = studentService.getStudentByEmail(updatedUser.getEmail());

            if (student != null) {

                student.setFullName(updatedUser.getFullName());
                student.setEmail(updatedUser.getEmail());
                student.setPhone(updatedUser.getPhone());
                student.setCourse(updatedUser.getCourse());

                studentService.updateStudent(student.getId(), student);
            }

            return updatedUser;
        }

        return null;
    }

    // ===========================
    // Delete User
    // ===========================
    public void deleteUser(Long id) {

        User user = userRepository.findById(id).orElse(null);

        if (user != null) {

            Student student = studentService.getStudentByEmail(user.getEmail());

            if (student != null) {
                studentService.deleteStudent(student.getId());
            }

            userRepository.deleteById(id);

        } else {
            throw new RuntimeException("User Not Found");
        }
    }

    // ===========================
    // User Count
    // ===========================
    public Long getUserCount() {
        return userRepository.count();
    }
}