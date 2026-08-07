package com.skillforge.dashboard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillforge.repository.CourseRepository;
import com.skillforge.repository.EnrollmentRepository;
import com.skillforge.repository.FeedbackRepository;
import com.skillforge.repository.UserRepository;

@Service
public class DashboardService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @Autowired
    private FeedbackRepository feedbackRepository;

    public DashboardResponse getDashboardData() {

        long users = userRepository.count();
        long courses = courseRepository.count();
        long enrollments = enrollmentRepository.count();
        long feedback = feedbackRepository.count();

        return new DashboardResponse(
                users,
                courses,
                enrollments,
                feedback
        );
    }

}