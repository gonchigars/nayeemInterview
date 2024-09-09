package com.example.demo.service;

import com.example.demo.model.Availability;
import com.example.demo.model.Session;
import com.example.demo.model.User;
import com.example.demo.repository.AvailabilityRepository;
import com.example.demo.repository.SessionRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.dto.SessionRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Service
public class SessionService {

    @Autowired
    private SessionRepository sessionRepository;

    @Autowired
    private AvailabilityRepository availabilityRepository;

    @Autowired
    private UserRepository userRepository;

    // Scheduling a session
    public Session scheduleSession(SessionRequest sessionRequest) {
        User admin = userRepository.findById(sessionRequest.getAdminId())
                .orElseThrow(() -> new RuntimeException("Admin not found"));
        Availability availability = availabilityRepository.findById(sessionRequest.getAvailabilityId())
                .orElseThrow(() -> new RuntimeException("Availability not found"));

        // Extract the availability times as LocalTime
        LocalTime availabilityStartTime = availability.getStartTime();
        LocalTime availabilityEndTime = availability.getEndTime();

        // Get the session times from the request
        LocalDateTime sessionStartTime = sessionRequest.getStartTime();
        LocalDateTime sessionEndTime = sessionRequest.getEndTime();

        // Check if the session times are within the availability period on the same day
        if (sessionStartTime.toLocalTime().isBefore(availabilityStartTime) ||
            sessionEndTime.toLocalTime().isAfter(availabilityEndTime)) {
            throw new RuntimeException("Session times conflict with availability");
        }

        // Create and save the session
        Session session = new Session(admin, availability, sessionStartTime, sessionEndTime, sessionRequest.getSessionType());
        return sessionRepository.save(session);
    }

    // Rescheduling a session
    public Session rescheduleSession(Long sessionId, SessionRequest sessionRequest) {
        Session session = sessionRepository.findById(sessionId)
                .orElseThrow(() -> new RuntimeException("Session not found"));

        session.setStartTime(sessionRequest.getStartTime());
        session.setEndTime(sessionRequest.getEndTime());
        session.setSessionType(sessionRequest.getSessionType());
        return sessionRepository.save(session);
    }

    // Canceling a session
    public void cancelSession(Long sessionId) {
        sessionRepository.deleteById(sessionId);
    }

    // Get all sessions
    public List<Session> getAllSessions() {
        return sessionRepository.findAll();
    }

    // Get sessions by user ID (admin in this case)
    public List<Session> getSessionsByUserId(Long userId) {
        return sessionRepository.findByAdminId(userId);
    }
}
