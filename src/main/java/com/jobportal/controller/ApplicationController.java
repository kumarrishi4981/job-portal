package com.jobportal.controller;

import com.jobportal.model.Application;
import com.jobportal.model.User;
import com.jobportal.model.Job;
import com.jobportal.repository.ApplicationRepository;
import com.jobportal.repository.UserRepository;
import com.jobportal.repository.JobRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/applications")
public class ApplicationController {

    private final ApplicationRepository applicationRepository;
    private final UserRepository userRepository;
    private final JobRepository jobRepository;

    public ApplicationController(ApplicationRepository applicationRepository,
                                 UserRepository userRepository,
                                 JobRepository jobRepository) {
        this.applicationRepository = applicationRepository;
        this.userRepository = userRepository;
        this.jobRepository = jobRepository;
    }

    // ✅ Apply for a job
    @PostMapping("/apply")
    public Application applyForJob(@RequestParam Long userId, @RequestParam Long jobId) {
        User user = userRepository.findById(userId).orElse(null);
        Job job = jobRepository.findById(jobId).orElse(null);

        if (user == null || job == null) {
            throw new RuntimeException("Invalid User or Job ID");
        }

        Application application = new Application(user, job, "Applied");
        return applicationRepository.save(application);
    }

    // ✅ Get all applications
    @GetMapping
    public List<Application> getAllApplications() {
        return applicationRepository.findAll();
    }

    // ✅ Get applications by User
    @GetMapping("/user/{userId}")
    public List<Application> getApplicationsByUser(@PathVariable Long userId) {
        return applicationRepository.findByUserId(userId);
    }

    // ✅ Get applications by Job
    @GetMapping("/job/{jobId}")
    public List<Application> getApplicationsByJob(@PathVariable Long jobId) {
        return applicationRepository.findByJobId(jobId);
    }

    // ✅ Update application status (e.g., Reviewed, Accepted, Rejected)
    @PutMapping("/{id}/status")
    public Application updateStatus(@PathVariable Long id, @RequestParam String status) {
        return applicationRepository.findById(id).map(app -> {
            app.setStatus(status);
            return applicationRepository.save(app);
        }).orElse(null);
    }
}
