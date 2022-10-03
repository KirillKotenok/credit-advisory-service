package com.kornello.creditadvisoryservice.controller;

import com.kornello.creditadvisoryservice.error.AdvisorAlreadyAssignedException;
import com.kornello.creditadvisoryservice.error.NoAdvisorFoundException;
import com.kornello.creditadvisoryservice.error.NoApplicationFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler({AdvisorAlreadyAssignedException.class, NoAdvisorFoundException.class,
            NoApplicationFoundException.class, IllegalStateException.class, IllegalArgumentException.class,
            NullPointerException.class})
    public ResponseEntity<String> handleException(Exception e) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(e.getMessage());
    }
}
