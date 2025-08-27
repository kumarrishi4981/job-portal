package com.jobportal.model;

import jakarta.persistence.*;

@Entity
@Table(name = "applications")
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // relation with User
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    // relation with Job
    @ManyToOne
    @JoinColumn(name = "job_id", nullable = false)
    private Job job;

    private String status; // e.g., "Applied", "Reviewed", "Accepted", "Rejected"

    public Application() {}

    public Application(User user, Job job, String status) {
        this.user = user;
        this.job = job;
        this.status = status;
    }

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public Job getJob() { return job; }
    public void setJob(Job job) { this.job = job; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
