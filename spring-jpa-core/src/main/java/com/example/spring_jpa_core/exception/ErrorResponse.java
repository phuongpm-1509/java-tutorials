package com.example.spring_jpa_core.exception;

public class ErrorResponse {
    private String message;
    private int status;
    private String error;

    public ErrorResponse() {
    }

    public ErrorResponse(String message, int status, String error) {
        this.message = message;
        this.status = status;
        this.error = error;
    }

    // Getters needed for JSON serialization
    public String getMessage() {
        return message;
    }

    public int getStatus() {
        return status;
    }

    public String getError() {
        return error;
    }
}
