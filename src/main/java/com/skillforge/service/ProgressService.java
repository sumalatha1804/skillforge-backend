package com.skillforge.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillforge.entity.Progress;
import com.skillforge.repository.ProgressRepository;

@Service
public class ProgressService {

    @Autowired
    private ProgressRepository progressRepository;

    // Add Progress
    public Progress addProgress(Progress progress) {
        return progressRepository.save(progress);
    }

    // Get All Progress
    public List<Progress> getAllProgress() {
        return progressRepository.findAll();
    }

    // Search Progress
    public List<Progress> searchProgress(String studentName) {
        return progressRepository.findByStudentNameContainingIgnoreCase(studentName);
    }

    // Get Progress By ID
    public Progress getProgressById(Long id) {
        return progressRepository.findById(id).orElse(null);
    }

    // Update Progress
    public Progress updateProgress(Long id, Progress progress) {

        Progress existing = progressRepository.findById(id).orElse(null);

        if (existing != null) {

            existing.setStudentName(progress.getStudentName());
            existing.setCourseName(progress.getCourseName());
            existing.setProgress(progress.getProgress());

            return progressRepository.save(existing);
        }

        return null;
    }

    // Delete Progress
    public void deleteProgress(Long id) {
        progressRepository.deleteById(id);
    }

}