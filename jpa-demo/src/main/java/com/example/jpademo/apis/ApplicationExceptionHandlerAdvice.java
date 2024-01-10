package com.example.jpademo.apis;

import com.example.jpademo.exceptions.RecordNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.util.Map;

@ControllerAdvice
public class ApplicationExceptionHandlerAdvice {
    private final Logger logger;

    public ApplicationExceptionHandlerAdvice() {
        logger = LoggerFactory.getLogger(this.getClass().getName());
    }

    @ExceptionHandler(RecordNotFoundException.class)
    public ResponseEntity<?> handleRecordNotFoundException(RecordNotFoundException e) {
        logger.warn(e.getMessage());
        return ResponseEntity.status(404).body(Map.of("error", e.getMessage()));
    }
}
