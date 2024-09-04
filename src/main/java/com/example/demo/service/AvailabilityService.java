package com.example.demo.service;

import com.example.demo.model.AvailabilitySlot;
import com.example.demo.model.User;
import com.example.demo.repository.AvailabilitySlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class AvailabilityService {

    // Logger to track events
    private static final Logger log = LoggerFactory.getLogger(AvailabilityService.class);

    @Autowired
    private AvailabilitySlotRepository availabilitySlotRepository;

    public AvailabilitySlot createAvailability(User user, LocalDateTime start, LocalDateTime end, int duration) {
        log.info("Creating availability for user: {}, start: {}, end: {}, duration: {}", user.getEmail(), start, end, duration);
        
        AvailabilitySlot slot = new AvailabilitySlot();
        slot.setUser(user);
        slot.setStart(start);
        slot.setEndTime(end);
        slot.setDuration(duration);
        
        return availabilitySlotRepository.save(slot);
    }

    public List<AvailabilitySlot> getUserAvailability(User user) {
        return availabilitySlotRepository.findByUser(user);
    }

    public void deleteAvailability(Long id) {
        availabilitySlotRepository.deleteById(id);
    }

    public List<AvailabilitySlot> getAllAvailabilities() {
        return availabilitySlotRepository.findAll();
    }
}
