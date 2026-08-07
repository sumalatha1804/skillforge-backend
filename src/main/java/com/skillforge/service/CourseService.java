package com.skillforge.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillforge.entity.Course;
import com.skillforge.repository.CourseRepository;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    // Add Course
    public Course addCourse(Course course) {
        return courseRepository.save(course);
    }

    // Get All Courses
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    // Get Course By Id
    public Course getCourseById(Long id) {
        return courseRepository.findById(id).orElse(null);
    }

    // Update Course
    public Course updateCourse(Long id, Course course) {

        Course existingCourse = courseRepository.findById(id).orElse(null);

        if (existingCourse != null) {

            existingCourse.setCourseName(course.getCourseName());
            existingCourse.setTrainerName(course.getTrainerName());
            existingCourse.setDuration(course.getDuration());

            return courseRepository.save(existingCourse);
        }

        return null;
    }

    // Delete Course
    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }
     // Search Course
        public List<Course> searchCourses(String courseName) {
            return courseRepository.findByCourseNameContaining(courseName);
        }
    }
