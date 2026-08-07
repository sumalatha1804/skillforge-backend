package com.skillforge.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillforge.entity.Feedback;
import com.skillforge.repository.FeedbackRepository;

@Service
public class FeedbackService {

    @Autowired
    private FeedbackRepository feedbackRepository;

    // Add Feedback
    public Feedback addFeedback(Feedback feedback) {
        return feedbackRepository.save(feedback);
    }

    // Get All Feedback
    public List<Feedback> getAllFeedback() {
        return feedbackRepository.findAll();
    }

    // ⭐ Search Feedback
    public List<Feedback> searchFeedback(String studentName) {
        return feedbackRepository.findByStudentNameContainingIgnoreCase(studentName);
    }

    // Get Feedback By ID
    public Feedback getFeedbackById(Long id) {
        return feedbackRepository.findById(id).orElse(null);
    }

    // Update Feedback
    public Feedback updateFeedback(Long id, Feedback feedback) {

        Feedback existing = feedbackRepository.findById(id).orElse(null);

        if (existing != null) {

            existing.setStudentName(feedback.getStudentName());
            existing.setCourseName(feedback.getCourseName());
            existing.setComments(feedback.getComments());
            existing.setRating(feedback.getRating());

            return feedbackRepository.save(existing);
        }

        return null;
    }

    // Delete Feedback
    public void deleteFeedback(Long id) {
        feedbackRepository.deleteById(id);
    }

}