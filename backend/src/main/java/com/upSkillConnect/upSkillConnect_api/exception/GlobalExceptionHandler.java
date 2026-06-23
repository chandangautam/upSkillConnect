package com.upSkillConnect.upSkillConnect_api.exception;

import java.util.HashMap;
import java.util.Map;
import org.springframework.web.bind.MethodArgumentNotValidException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.upSkillConnect.upSkillConnect_api.common.ApiResponseDTO;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(EmailAlreadyExistsException.class)
    public ResponseEntity<ApiResponseDTO<Void>> handleEmailExists(EmailAlreadyExistsException message) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(new ApiResponseDTO<>(message.getMessage(), false, null, null)); // 409
    }

    @ExceptionHandler(CompanyNameAlreadyExistsException.class)
    public ResponseEntity<ApiResponseDTO<Void>> handleCompanyNameExists(CompanyNameAlreadyExistsException message) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(new ApiResponseDTO<>(message.getMessage(), false, null, null)); // 409
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ApiResponseDTO<Void>> handleUserNotFound(UserNotFoundException message) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ApiResponseDTO<>(message.getMessage(), false, null, null)); // 404
    }

    @ExceptionHandler(RoleMismatchException.class)
    public ResponseEntity<ApiResponseDTO<Void>> handleRoleMismatchException(RoleMismatchException message) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ApiResponseDTO<>(message.getMessage(), false, null, null)); // 404
    }

    @ExceptionHandler(JobNotFoundException.class)
    public ResponseEntity<ApiResponseDTO<Void>> handleJobNotFound(JobNotFoundException message) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ApiResponseDTO<>(message.getMessage(), false, null, null)); // 404
    }

    @ExceptionHandler(ResumeNotFoundException.class)
    public ResponseEntity<ApiResponseDTO<Void>> handleJobNotFound(ResumeNotFoundException message) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ApiResponseDTO<>(message.getMessage(), false, null, null)); // 404
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponseDTO<Map<String, String>>> handleValidationErrors(
            MethodArgumentNotValidException methodArgumentNotValidException) {

        Map<String, String> errors = new HashMap<>();

        for (FieldError error : methodArgumentNotValidException.getBindingResult().getFieldErrors()) {
            errors.put(error.getField(), error.getDefaultMessage());
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ApiResponseDTO<>("Validation Failed", false, null, errors));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponseDTO<Void>> handleGenericException(Exception message) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ApiResponseDTO<>("Something went wrong", false, null, null)); // 500
    }
}