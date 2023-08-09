package com.example.rimba.service;

public class ApiResponse {
    private Integer status;
    private String message;
    private Object data;

    public ApiResponse(Integer status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public Integer getStatus() {
        return status;
    }
    
    public String getMessage() {
        return message;
    }

    public Object getData() {
        return data;
    }
}

