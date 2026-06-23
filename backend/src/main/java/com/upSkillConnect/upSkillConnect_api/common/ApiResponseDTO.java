package com.upSkillConnect.upSkillConnect_api.common;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponseDTO<T> {

    private String message;
    private boolean success;
    private T data;
    Map<String, String> errors;

    public ApiResponseDTO() {

    }

    public ApiResponseDTO(String message, boolean success, T data, Map<String, String> errors) {
        this.message = message;
        this.success = success;
        this.data = data;
        this.errors = errors;
    }

    public String getMessage() {
        return message;
    }

    public boolean getSuccess() {
        return success;
    }

    public T getData() {
        return data;
    }

    public Map<String, String> getErrors() {
        return errors;
    }
}