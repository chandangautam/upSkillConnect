package com.upSkillConnect.upSkillConnect_api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.upSkillConnect.upSkillConnect_api.common.ApiResponseDTO;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(EmailAlreadyExistsException.class)
    public ResponseEntity<ApiResponseDTO<Void>> handleEmailExists(EmailAlreadyExistsException message) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(new ApiResponseDTO<>(message.getMessage(), false)); // 409
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ApiResponseDTO<Void>> handleUserNotFound(UserNotFoundException message) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ApiResponseDTO<>(message.getMessage(), false)); // 404
    }

    @ExceptionHandler(RoleMismatchException.class)
    public ResponseEntity<ApiResponseDTO<Void>> handleRoleMismatchException(Exception message) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ApiResponseDTO<>(message.getMessage(), false)); // 404
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponseDTO<Void>> handleGenericException(Exception message) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ApiResponseDTO<>("Something went wrong", false)); // 500
    }
}