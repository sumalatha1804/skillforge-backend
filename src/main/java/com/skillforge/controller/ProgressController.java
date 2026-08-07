package com.skillforge.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.skillforge.entity.Progress;
import com.skillforge.service.ProgressService;

@RestController
@RequestMapping("/progress")
@CrossOrigin("*")
public class ProgressController {

    @Autowired
    private ProgressService progressService;

    // Add Progress
    @PostMapping
    public Progress addProgress(@RequestBody Progress progress) {
        return progressService.addProgress(progress);
    }

    // Get All Progress
    @GetMapping
    public List<Progress> getAllProgress() {
        return progressService.getAllProgress();
    }

    // ⭐ Search Progress by Student Name
    @GetMapping("/search/{studentName}")
    public List<Progress> searchProgress(@PathVariable String studentName) {
        return progressService.searchProgress(studentName);
    }

    // Get Progress By ID
    @GetMapping("/{id}")
    public Progress getProgressById(@PathVariable Long id) {
        return progressService.getProgressById(id);
    }

    // Update Progress
    @PutMapping("/{id}")
    public Progress updateProgress(@PathVariable Long id,
                                   @RequestBody Progress progress) {
        return progressService.updateProgress(id, progress);
    }

    // Delete Progress
    @DeleteMapping("/{id}")
    public String deleteProgress(@PathVariable Long id) {
        progressService.deleteProgress(id);
        return "Progress Deleted Successfully";
    }
}