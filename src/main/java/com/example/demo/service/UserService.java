// File: src/main/java/com/example/demo/service/UserService.java
package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Register a new user
    public User registerUser(User user) {
        return userRepository.save(user);
    }

    // Authenticate a user by email and password
    // public boolean authenticate(String email) {
    //     Optional<User> userOptional = userRepository.findByEmail(email);
    //    if (userOptional.isPresent()) {
    //         User user = userOptional.get();
    //         return password.equals(user.getPassword());  // Just comparing passwords here
    //     }
    //     return false;
    // }

    // Get a user by ID
    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }
}
