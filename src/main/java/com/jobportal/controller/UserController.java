package com.jobportal.controller;

import com.jobportal.model.User;
import com.jobportal.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // ✅ Get all users
    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // ✅ Create new user
    @PostMapping
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    // ✅ Get user by ID
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userRepository.findById(id).orElse(null);
    }

    // ✅ Delete user by ID
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);
        return "User deleted with id " + id;
    }

    // ✅ Simple login check
    @PostMapping("/login")
    public String loginUser(@RequestBody User loginRequest) {
        User user = userRepository.findByEmail(loginRequest.getEmail());
        if (user != null && user.getPassword().equals(loginRequest.getPassword())) {
            return "Login successful!";
        } else {
            return "Invalid email or password!";
        }
    }
}
