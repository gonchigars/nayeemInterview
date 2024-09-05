
package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/users") // Base path for all user-related APIs
public class UserController {

    @Autowired
    private UserService userService;

    // API endpoint to register a new user
    @PostMapping("/create")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        try {
            User createdUser = userService.createUser(user.getEmail());
            return ResponseEntity.ok("User registered with email: " + createdUser.getEmail());
        } catch (Exception e) {
            return ResponseEntity.status(409).body(e.getMessage()); // 409 Conflict if user already exists
        }
    }

    // API endpoint to login a user
    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody User user) {
        try {
            Optional<User> loggedInUser = userService.getUserByEmail(user.getEmail());
            return ResponseEntity.ok("Login successful for email: " + loggedInUser.get().getEmail());
        } catch (Exception e) {
            return ResponseEntity.status(404).body(e.getMessage()); // 404 Not Found if user not found
        }
    }

    // API endpoint to get user info by email (you can adjust this based on requirements)
    @GetMapping("/{email}")
    public ResponseEntity<User> getUserByEmail(@PathVariable String email) {
        try {
            Optional<User> user = userService.getUserByEmail(email);
            return ResponseEntity.ok(user.get());
        } catch (Exception e) {
            return ResponseEntity.status(404).body(null); // 404 Not Found if user not found
        }
    }
}
