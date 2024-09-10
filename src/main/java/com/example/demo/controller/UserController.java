// File: src/main/java/com/example/demo/controller/UserController.java
package com.example.demo.controller;

import com.example.demo.dto.UserDTO;
import com.example.demo.dto.LoginRequestDTO;
import com.example.demo.dto.UserResponseDTO;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserResponseDTO> registerUser(@RequestBody UserDTO userDTO) {
        // Convert UserDTO to User entity
        User user = new User(userDTO.getEmail(), userDTO.getRole());
        // Register the user and get the saved User entity
        User registeredUser = userService.registerUser(user);

        // Convert the User entity to UserResponseDTO and return it
        UserResponseDTO userResponseDTO = new UserResponseDTO(
                registeredUser.getId(),
                registeredUser.getEmail(),
                registeredUser.getRole()
        );
        return ResponseEntity.ok(userResponseDTO);
    }

    // @PostMapping("/login")
    // public ResponseEntity<String> loginUser(@RequestBody LoginRequestDTO loginRequestDTO) {
    //     boolean isAuthenticated = userService.authenticate(loginRequestDTO.getEmail(), loginRequestDTO.getPassword());
    //     if (isAuthenticated) {
    //         return ResponseEntity.ok("Login successful");
    //     } else {
    //         return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
    //     }
    // }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> getUserById(@PathVariable Long id) {
        User user = userService.getUserById(id);
        
        // Convert the User entity to UserResponseDTO and return it
        UserResponseDTO userResponseDTO = new UserResponseDTO(user.getId(), user.getEmail(), user.getRole());
        return ResponseEntity.ok(userResponseDTO);
    }
}
