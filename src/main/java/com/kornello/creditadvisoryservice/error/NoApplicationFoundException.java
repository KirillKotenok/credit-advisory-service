package com.kornello.creditadvisoryservice.error;

public class NoApplicationFoundException extends RuntimeException{
    public NoApplicationFoundException() {
    }

    public NoApplicationFoundException(String message) {
        super(message);
    }
}
