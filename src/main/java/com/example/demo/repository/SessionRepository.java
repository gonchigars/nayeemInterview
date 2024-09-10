package com.example.demo.repository;

import com.example.demo.model.Session;
import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface SessionRepository extends JpaRepository<Session, Long> {
    
    // Query to find sessions by admin (User object)
    List<Session> findByAdmin(User admin);

    // Query to find sessions by admin ID
    List<Session> findByAdminId(Long adminId);

    // Additional query to find sessions by availability (if needed)
    List<Session> findByAvailabilityId(Long availabilityId);
}
