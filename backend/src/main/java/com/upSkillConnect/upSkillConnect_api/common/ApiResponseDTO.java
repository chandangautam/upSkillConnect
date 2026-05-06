package com.upSkillConnect.upSkillConnect_api.common;

public class ApiResponseDTO<T> {

    private String message;
    private T data;

    public ApiResponseDTO() {

    }

    public ApiResponseDTO(String message, T data) {
        this.message = message;
        this.data=data;
    } 

    public String getMessage(){
        return message;
    }

    public T getData(){
        return data;
    }
}
