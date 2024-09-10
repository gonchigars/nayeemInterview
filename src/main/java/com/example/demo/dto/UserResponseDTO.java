// File: src/main/java/com/example/demo/dto/UserResponseDTO.java
package com.example.demo.dto;

public class UserResponseDTO {
    private Long id;
    private String email;
    private String role;

    // Constructors
    public UserResponseDTO() {}

    public UserResponseDTO(Long id, String email, String role) {
        this.id = id;
        this.email = email;
        this.role = role;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
