package com.atexo.atexotechbackend.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.net.URI;
import java.time.Instant;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorResponse> handelEntityNotFoundException (EntityNotFoundException ex , WebRequest request) {


        ErrorResponse response = new ErrorResponse();
        response.setUri(URI.create(""));
        response.setMessage(ex.getMessage());
        response.setTimestamp(Instant.now());
        response.setStatus(HttpStatus.NOT_FOUND.value());
        response.setTitle("Entity not found");
        response.setInstance(URI.create(request.getDescription(false)));
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
}
