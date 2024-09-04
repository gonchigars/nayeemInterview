package com.example.demo.service;

import com.example.demo.model.Session;
import com.example.demo.model.User;
import com.example.demo.repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SessionService {

    @Autowired
    private SessionRepository sessionRepository;

    public Session createSession(LocalDateTime startTime, LocalDateTime endTime, List<User> participants) {
        Session session = new Session();
        session.setStartTime(startTime);
        session.setEndTime(endTime);
        session.setParticipants(participants);
        return sessionRepository.save(session);
    }

    public List<Session> getAllSessions() {
        return sessionRepository.findAll();
    }

    // Conflict checking logic to ensure no overlap with existing sessions or availability
    public boolean isConflict(LocalDateTime startTime, LocalDateTime endTime, List<User> participants) {
        List<Session> allSessions = sessionRepository.findAll();
        for (User participant : participants) {
            List<Session> userSessions = allSessions.stream()
                .filter(session -> session.getParticipants().contains(participant))
                .collect(Collectors.toList());
            for (Session session : userSessions) {
                if ((startTime.isBefore(session.getEndTime()) && startTime.isAfter(session.getStartTime())) ||
                    (endTime.isBefore(session.getEndTime()) && endTime.isAfter(session.getStartTime()))) {
                    return true;  // Conflict found
                }
            }
        }
        return false;
    }

    // Add other methods like rescheduling, canceling sessions if required
}
