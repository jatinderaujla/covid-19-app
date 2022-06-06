package com.example.exception;

/**
 * @author Jatinder
 * @since 1.0.0
 */
public class AvailabilityStateException extends RuntimeException {
    public AvailabilityStateException(String message) {
        super(message);
    }
}
