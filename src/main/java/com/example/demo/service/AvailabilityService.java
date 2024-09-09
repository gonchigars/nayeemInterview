package com.example.demo.service;

import com.example.demo.model.Availability;
import com.example.demo.model.User;
import com.example.demo.repository.AvailabilityRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AvailabilityService {

    @Autowired
    private AvailabilityRepository availabilityRepository;

    @Autowired
    private UserRepository userRepository;

    public Availability addAvailability(Availability availability) {
        return availabilityRepository.save(availability);
    }

    public Availability updateAvailability(Long id, Availability updatedAvailability) {
        Availability availability = availabilityRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Availability not found"));
        availability.setDayOfWeek(updatedAvailability.getDayOfWeek());
        availability.setStartTime(updatedAvailability.getStartTime());
        availability.setEndTime(updatedAvailability.getEndTime());
        availability.setIntervalDuration(updatedAvailability.getIntervalDuration());
        return availabilityRepository.save(availability);
    }

    public void deleteAvailability(Long id) {
        availabilityRepository.deleteById(id);
    }

    public List<Availability> getAvailabilityByUserId(Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            return availabilityRepository.findByUserId(userId);
        }
        throw new RuntimeException("User not found");
    }
}
