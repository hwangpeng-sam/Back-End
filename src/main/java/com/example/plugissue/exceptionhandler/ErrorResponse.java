package com.example.plugissue.exceptionhandler;

import lombok.Builder;

import java.util.Map;

public class ErrorResponse {

    private String code;
    private String message;
    private Map<String,String> errors;

    @Builder
    public ErrorResponse(String code, String message, Map<String,String> errors){
        this.code = code;
        this.message = message;
        this.errors = errors;
    }
}
