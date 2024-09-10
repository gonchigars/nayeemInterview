package com.example.demo.controller;

import com.example.demo.dto.AvailabilityDTO;
import com.example.demo.model.Availability;
import com.example.demo.model.User;
import com.example.demo.service.AvailabilityService;
import com.example.demo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/availability")
public class AvailabilityController {

    private static final Logger logger = LoggerFactory.getLogger(AvailabilityController.class);

    @Autowired
    private AvailabilityService availabilityService;

    @Autowired
    private UserService userService;  // Inject UserService to fetch the user

    public AvailabilityController() {
        logger.info("AvailabilityController instantiated");
    }

    @PostMapping("/add")
    public ResponseEntity<Availability> addAvailability(@RequestBody Availability availability, @RequestParam Long userId) {
        logger.info("Received request to add availability: {}", availability);

        // Fetch the user by userId
        User user = userService.getUserById(userId);
        availability.setUser(user);  // Set the user in the availability

        try {
            Availability newAvailability = availabilityService.addAvailability(availability);
            logger.info("New availability added: {}", newAvailability);
            return ResponseEntity.ok(newAvailability);
        } catch (Exception e) {
            logger.error("Error adding availability: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Availability> updateAvailability(@PathVariable Long id, @RequestBody Availability availability) {
        logger.info("Received request to update availability with id: {}", id);
        Availability updatedAvailability = availabilityService.updateAvailability(id, availability);
        logger.info("Availability updated: {}", updatedAvailability);
        return ResponseEntity.ok(updatedAvailability);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteAvailability(@PathVariable Long id) {
        logger.info("Received request to delete availability with id: {}", id);
        availabilityService.deleteAvailability(id);
        logger.info("Availability deleted successfully");
        return ResponseEntity.ok("Availability deleted successfully");
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<AvailabilityDTO>> getUserAvailability(@PathVariable Long userId) {
        logger.info("Received request to get availability for user with id: {}", userId);
        List<Availability> availabilityList = availabilityService.getAvailabilityByUserId(userId);

        // Convert the Availability list to AvailabilityDTO
        List<AvailabilityDTO> availabilityDTOList = availabilityList.stream()
                .map(availability -> new AvailabilityDTO(
                        availability.getId(),
                        availability.getDayOfWeek(),
                        availability.getStartTime(),
                        availability.getEndTime(),
                        availability.getIntervalDuration()
                ))
                .collect(Collectors.toList());

        return ResponseEntity.ok(availabilityDTOList);
    }

    @GetMapping("/test")
    public ResponseEntity<String> test() {
        logger.info("Test endpoint hit");
        return ResponseEntity.ok("AvailabilityController is working!");
    }
}
