package com.skillforge.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillforge.entity.Student;
import com.skillforge.repository.StudentRepository;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    // ===========================
    // Save Student (Avoid Duplicate)
    // ===========================
    public Student saveStudent(Student student) {

        Student existingStudent = studentRepository.findByEmail(student.getEmail());

        if (existingStudent != null) {
            return existingStudent; // Already exists
        }

        return studentRepository.save(student);
    }

    // ===========================
    // Get All Students
    // ===========================
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // ===========================
    // Get Student By Id
    // ===========================
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    // ===========================
    // Get Student By Email
    // ===========================
    public Student getStudentByEmail(String email) {
        return studentRepository.findByEmail(email);
    }

    // ===========================
    // Update Student
    // ===========================
    public Student updateStudent(Long id, Student student) {

        Student existingStudent = studentRepository.findById(id).orElse(null);

        if (existingStudent != null) {

            existingStudent.setFullName(student.getFullName());
            existingStudent.setEmail(student.getEmail());
            existingStudent.setPhone(student.getPhone());
            existingStudent.setCourse(student.getCourse());

            return studentRepository.save(existingStudent);
        }

        return null;
    }

    // ===========================
    // Delete Student
    // ===========================
    public void deleteStudent(Long id) {

        if (studentRepository.existsById(id)) {
            studentRepository.deleteById(id);
        } else {
            throw new RuntimeException("Student Not Found");
        }
    }

    // ===========================
    // Student Count
    // ===========================
    public Long getStudentCount() {
        return studentRepository.count();
    }
}