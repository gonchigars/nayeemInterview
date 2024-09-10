package com.example.demo.service;

import com.example.demo.model.Session;
import com.example.demo.repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService {

    @Autowired
    private SessionRepository sessionRepository;

    /**
     * Retrieve sessions scheduled by a specific admin.
     * @param adminId the ID of the admin user
     * @return a list of sessions scheduled by the given admin
     */
    public List<Session> getSessionsByAdmin(Long adminId) {
        return sessionRepository.findByAdminId(adminId);
    }

    /**
     * Retrieve all sessions for a given availability.
     * @param availabilityId the ID of the availability slot
     * @return a list of sessions associated with the given availability
     */
    public List<Session> getSessionsByAvailability(Long availabilityId) {
        return sessionRepository.findByAvailabilityId(availabilityId);
    }
    
    // You can add more methods here related to notifications
}
