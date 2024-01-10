package com.example.webservicedemo.apis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ApplicationExceptionHandlerAdvice {
    private final Logger logger;

    public ApplicationExceptionHandlerAdvice() {
        logger = LoggerFactory.getLogger(this.getClass().getName());
    }


    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<?> handleIllegalArgumentException(IllegalArgumentException iae) {
        logger.warn(iae.getMessage());

        Map<String, String> map = Map.of("error", iae.getMessage());
        return ResponseEntity.badRequest().body(map);
    }
}
