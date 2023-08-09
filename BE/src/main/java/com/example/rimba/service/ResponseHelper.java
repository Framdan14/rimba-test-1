package com.example.rimba.service;

public class ResponseHelper {
    public static ApiResponse createSuccessResponse(Integer status, String message, Object data) {
        return new ApiResponse(status, message, data);
    }

    public static ApiResponse createErrorResponse(Integer status, String message, Object data) {
        return new ApiResponse(status, message, data);
    }
}
