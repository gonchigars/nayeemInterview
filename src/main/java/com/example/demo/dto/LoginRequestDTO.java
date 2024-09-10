// File: src/main/java/com/example/demo/dto/LoginRequestDTO.java
package com.example.demo.dto;

public class LoginRequestDTO {
    private String email;

    // Constructors
    public LoginRequestDTO() {}

    public LoginRequestDTO(String email) {
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
