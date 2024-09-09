package com.example.demo.controller;

import com.example.demo.model.Session;
import com.example.demo.service.SessionService;
import com.example.demo.dto.SessionRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sessions")
public class SessionController {

    @Autowired
    private SessionService sessionService;

    @PostMapping("/schedule")
    public ResponseEntity<Session> scheduleSession(@RequestBody SessionRequest sessionRequest) {
        Session session = sessionService.scheduleSession(sessionRequest);
        return ResponseEntity.ok(session);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Session>> getAllSessions() {
        List<Session> sessions = sessionService.getAllSessions();
        return ResponseEntity.ok(sessions);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Session>> getUserSessions(@PathVariable Long userId) {
        List<Session> userSessions = sessionService.getSessionsByUserId(userId);
        return ResponseEntity.ok(userSessions);
    }

    @PutMapping("/reschedule/{id}")
    public ResponseEntity<Session> rescheduleSession(@PathVariable Long id, @RequestBody SessionRequest sessionRequest) {
        Session updatedSession = sessionService.rescheduleSession(id, sessionRequest);
        return ResponseEntity.ok(updatedSession);
    }

    @DeleteMapping("/cancel/{id}")
    public ResponseEntity<String> cancelSession(@PathVariable Long id) {
        sessionService.cancelSession(id);
        return ResponseEntity.ok("Session cancelled successfully");
    }
}
