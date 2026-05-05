package com.upSkillConnect.upSkillConnect_api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(EmailAlreadyExistsException.class)
    public ResponseEntity<String> handleEmailExists(EmailAlreadyExistsException message) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(message.getMessage()); // 409
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<String> handleUserNotFound(UserNotFoundException message) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(message.getMessage()); // 404
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGenericException(Exception message) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Something went wrong"); // 500
    }
}