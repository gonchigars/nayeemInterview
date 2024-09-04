package com.example.demo.controller;

import com.example.demo.model.Session;
import com.example.demo.model.User;
import com.example.demo.service.SessionService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/sessions")
public class SessionController {

    @Autowired
    private SessionService sessionService;

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<?> createSession(@RequestBody Map<String, Object> sessionData) {
        LocalDateTime startTime = LocalDateTime.parse((String) sessionData.get("startTime"));
        LocalDateTime endTime = LocalDateTime.parse((String) sessionData.get("endTime"));
        @SuppressWarnings("unchecked")
        List<String> emails = (List<String>) sessionData.get("participants");

        // Ensure all participants exist, and do not create new users
        List<User> participants = emails.stream()
            .map(email -> userService.getUserByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found")))
            .collect(Collectors.toList());

        // Conflict checking for availability
        if (sessionService.isConflict(startTime, endTime, participants)) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Session conflicts with existing availability or sessions.");
        }

        // Create the session
        Session session = sessionService.createSession(startTime, endTime, participants);
        return ResponseEntity.ok(session);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Session>> getAllSessions() {
        return ResponseEntity.ok(sessionService.getAllSessions());
    }

    // Add other endpoints for rescheduling or canceling sessions if needed
}
