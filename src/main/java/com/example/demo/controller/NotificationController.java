package com.example.demo.controller;

import com.example.demo.model.Session;
import com.example.demo.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    /**
     * REST API endpoint to get sessions scheduled by a specific admin.
     * @param adminId the ID of the admin user
     * @return a list of sessions scheduled by the given admin
     */
    @GetMapping("/sessions/admin/{adminId}")
    public List<Session> getSessionsByAdmin(@PathVariable Long adminId) {
        return notificationService.getSessionsByAdmin(adminId);
    }

    /**
     * REST API endpoint to get sessions associated with a specific availability.
     * @param availabilityId the ID of the availability slot
     * @return a list of sessions associated with the given availability
     */
    @GetMapping("/sessions/availability/{availabilityId}")
    public List<Session> getSessionsByAvailability(@PathVariable Long availabilityId) {
        return notificationService.getSessionsByAvailability(availabilityId);
    }

    // You can add more endpoints here as needed
}
