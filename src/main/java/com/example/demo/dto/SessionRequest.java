package com.example.demo.dto;

import java.time.LocalDateTime;

public class SessionRequest {
    private Long adminId;
    private Long availabilityId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String sessionType;

    public SessionRequest() {}

    public SessionRequest(Long adminId, Long availabilityId, LocalDateTime startTime, LocalDateTime endTime, String sessionType) {
        this.adminId = adminId;
        this.availabilityId = availabilityId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.sessionType = sessionType;
    }

    // Getters and Setters
    public Long getAdminId() {
        return adminId;
    }

    public void setAdminId(Long adminId) {
        this.adminId = adminId;
    }

    public Long getAvailabilityId() {
        return availabilityId;
    }

    public void setAvailabilityId(Long availabilityId) {
        this.availabilityId = availabilityId;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public String getSessionType() {
        return sessionType;
    }

    public void setSessionType(String sessionType) {
        this.sessionType = sessionType;
    }
}
