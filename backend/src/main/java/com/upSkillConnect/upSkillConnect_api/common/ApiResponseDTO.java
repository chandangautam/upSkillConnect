package com.upSkillConnect.upSkillConnect_api.common;

public class ApiResponseDTO<T> {

    private String message;
    boolean success;

    public ApiResponseDTO() {

    }

    public ApiResponseDTO(String message, boolean success) {
        this.message = message;
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public boolean getSuccess() {
        return success;
    }
}