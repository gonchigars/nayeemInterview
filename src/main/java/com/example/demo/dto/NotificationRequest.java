package com.example.demo.dto;

public class NotificationRequest {
    private Long userId;
    private String type;  // e.g., email, sms

    public NotificationRequest() {}

    public NotificationRequest(Long userId, String type) {
        this.userId = userId;
        this.type = type;
    }

    // Getters and Setters
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
