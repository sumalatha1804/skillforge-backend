package com.skillforge.dashboard;

public class DashboardResponse {

    private long users;
    private long courses;
    private long enrollments;
    private long feedback;

    public DashboardResponse() {
    }

    public DashboardResponse(long users, long courses, long enrollments, long feedback) {
        this.users = users;
        this.courses = courses;
        this.enrollments = enrollments;
        this.feedback = feedback;
    }

    public long getUsers() {
        return users;
    }

    public void setUsers(long users) {
        this.users = users;
    }

    public long getCourses() {
        return courses;
    }

    public void setCourses(long courses) {
        this.courses = courses;
    }

    public long getEnrollments() {
        return enrollments;
    }

    public void setEnrollments(long enrollments) {
        this.enrollments = enrollments;
    }

    public long getFeedback() {
        return feedback;
    }

    public void setFeedback(long feedback) {
        this.feedback = feedback;
    }
}