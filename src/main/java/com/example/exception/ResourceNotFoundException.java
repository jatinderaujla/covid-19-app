package com.example.exception;

/**
 * @author Jatinder
 * @since 1.0.0
 */
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
