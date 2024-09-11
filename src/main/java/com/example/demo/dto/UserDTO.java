// File: src/main/java/com/example/demo/dto/UserDTO.java
package com.example.demo.dto;

public class UserDTO {
    private String email;
    private String password;
    private String role;

    // Constructors
    public UserDTO() {}

    public UserDTO(String email,  String role) {
        this.email = email;
        // this.password = password;
        // modify
        this.role = role;
    }

    // Getters and Setters
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // public String getPassword() {
    //     return password;
    // }

    // public void setPassword(String password) {
    //     this.password = password;
    // }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
