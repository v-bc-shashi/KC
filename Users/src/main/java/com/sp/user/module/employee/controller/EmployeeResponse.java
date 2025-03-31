package com.sp.user.module.employee.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class EmployeeResponse {

    /**
     * Responce builder.
     *
     * @param message the message
     * @param status the status
     * @param responseObject the response object
     * @return the response entity
     */
    public static ResponseEntity<Object> responceBuilder(String message, HttpStatus status, Object responseObject){
        Map<String, Object> response = new HashMap<>();
        response.put("message", message);
        response.put("status", status);
        response.put("data", responseObject);
        return new ResponseEntity<>(response,status);
    }
}
