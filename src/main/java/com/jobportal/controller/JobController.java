package com.jobportal.controller;

import com.jobportal.model.Job;
import com.jobportal.repository.JobRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobs")
public class JobController {

    private final JobRepository jobRepository;

    public JobController(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    // ✅ Get all jobs
    @GetMapping
    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    // ✅ Create job posting
    @PostMapping
    public Job createJob(@RequestBody Job job) {
        return jobRepository.save(job);
    }

    // ✅ Get job by ID
    @GetMapping("/{id}")
    public Job getJobById(@PathVariable Long id) {
        return jobRepository.findById(id).orElse(null);
    }

    // ✅ Update job
    @PutMapping("/{id}")
    public Job updateJob(@PathVariable Long id, @RequestBody Job jobDetails) {
        return jobRepository.findById(id).map(job -> {
            job.setTitle(jobDetails.getTitle());
            job.setDescription(jobDetails.getDescription());
            job.setLocation(jobDetails.getLocation());
            job.setCompany(jobDetails.getCompany());
            job.setType(jobDetails.getType());
            job.setSalary(jobDetails.getSalary());
            return jobRepository.save(job);
        }).orElse(null);
    }

    // ✅ Delete job
    @DeleteMapping("/{id}")
    public String deleteJob(@PathVariable Long id) {
        jobRepository.deleteById(id);
        return "Job deleted with id " + id;
    }
}
