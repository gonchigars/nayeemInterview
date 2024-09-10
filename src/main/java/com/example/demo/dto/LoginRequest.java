package com.example.demo.dto;

public class LoginRequest {
    private String email;


    public LoginRequest() {}

    public LoginRequest(String email) {
        this.email = email;
        
    }

    // Getters and Setters
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

   
}
