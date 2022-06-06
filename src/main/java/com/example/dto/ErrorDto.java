package com.example.dto;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

/**
 * @author Jatinder
 * @since 1.0.0
 */
public class ErrorDto {
    private Integer statusCode;
    private HttpStatus status;
    private Object message;
    private LocalDateTime timeStamp = LocalDateTime.now();

    public ErrorDto() {

    }

    public ErrorDto(HttpStatus status, Object message, Integer statusCode) {
        this.status = status;
        this.message = message;
        this.statusCode = statusCode;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public Object getMessage() {
        return message;
    }

    public void setMessage(Object message) {
        this.message = message;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }
}
