package com.example.advice;

import com.example.dto.ErrorDto;
import com.example.exception.AvailabilityStateException;
import com.example.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author Jatinder
 * @since 1.0.0
 */
@RestControllerAdvice
public class AppAdvice {

    @ExceptionHandler(value = {ResourceNotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorDto handleResourceNotFoundException(ResourceNotFoundException exception){

        ErrorDto errorDto = new ErrorDto();
        errorDto.setMessage(exception.getMessage());
        errorDto.setStatus(HttpStatus.NOT_FOUND);
        errorDto.setStatusCode(HttpStatus.NOT_FOUND.value());
        return errorDto;
    }

    @ExceptionHandler(value = {AvailabilityStateException.class})
    @ResponseStatus(HttpStatus.EXPECTATION_FAILED)
    public ErrorDto handleAvailabilityStateExceptionException(AvailabilityStateException exception){

        ErrorDto errorDto = new ErrorDto();
        errorDto.setMessage(exception.getMessage());
        errorDto.setStatus(HttpStatus.EXPECTATION_FAILED);
        errorDto.setStatusCode(HttpStatus.EXPECTATION_FAILED.value());

        return errorDto;
    }
}
