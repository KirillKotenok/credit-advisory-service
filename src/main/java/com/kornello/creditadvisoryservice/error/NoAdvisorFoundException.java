package com.kornello.creditadvisoryservice.error;

public class NoAdvisorFoundException extends RuntimeException{
    public NoAdvisorFoundException() {
    }

    public NoAdvisorFoundException(String message) {
        super(message);
    }
}
