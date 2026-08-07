package com.skillforge.dto;

public class ProgressResponse {

    private String studentName;
    private String courseName;
    private int progress;

    public ProgressResponse() {
    }

    public ProgressResponse(String studentName, String courseName, int progress) {
        this.studentName = studentName;
        this.courseName = courseName;
        this.progress = progress;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }
}