
package com.example.demo.controller;

import com.example.demo.service.UserAlreadyExistsException;  // Import the exception
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)  // Return 409 Conflict status
    public String handleUserAlreadyExistsException(UserAlreadyExistsException e) {
        return e.getMessage();
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)  // Return 500 Internal Server Error status for generic issues
    public String handleRuntimeException(RuntimeException e) {
        return "Internal server error: " + e.getMessage();
    }
}
