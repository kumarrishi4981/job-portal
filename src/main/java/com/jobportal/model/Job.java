package com.jobportal.model;

import jakarta.persistence.*;

@Entity
@Table(name = "jobs")
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private String location;
    private String company;
    private String type; // Full-time, Part-time, Internship
    private double salary;

    public Job() {}

    public Job(String title, String description, String location, String company, String type, double salary) {
        this.title = title;
        this.description = description;
        this.location = location;
        this.company = company;
        this.type = type;
        this.salary = salary;
    }

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public String getCompany() { return company; }
    public void setCompany(String company) { this.company = company; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }
}
