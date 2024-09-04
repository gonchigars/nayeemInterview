package com.example.demo.controller;

import com.example.demo.model.AvailabilitySlot;
import com.example.demo.model.User;
import com.example.demo.service.AvailabilityService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/availability")
public class AvailabilityController {

    @Autowired
    private AvailabilityService availabilityService;

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<AvailabilitySlot> createAvailability(@RequestBody Map<String, Object> availabilityData) {
        String email = (String) availabilityData.get("user");
        LocalDateTime start = LocalDateTime.parse((String) availabilityData.get("start"));
        LocalDateTime end = LocalDateTime.parse((String) availabilityData.get("end"));
        int duration = (int) availabilityData.get("duration");

        // Ensure the user exists
        User user = userService.getUserByEmail(email).orElseThrow(() -> new RuntimeException("User not found"));

        AvailabilitySlot slot = availabilityService.createAvailability(user, start, end, duration);
        return ResponseEntity.ok(slot);
    }

    @GetMapping("/{email}")
    public ResponseEntity<List<AvailabilitySlot>> getUserAvailability(@PathVariable String email) {
        User user = userService.getUserByEmail(email).orElseThrow(() -> new RuntimeException("User not found"));
        return ResponseEntity.ok(availabilityService.getUserAvailability(user));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteAvailability(@PathVariable Long id) {
        availabilityService.deleteAvailability(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/all")
    public ResponseEntity<List<AvailabilitySlot>> getAllAvailabilities() {
        return ResponseEntity.ok(availabilityService.getAllAvailabilities());
    }
}
