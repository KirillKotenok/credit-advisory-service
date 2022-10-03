package com.kornello.creditadvisoryservice.error;

public class AdvisorAlreadyAssignedException extends RuntimeException{
    public AdvisorAlreadyAssignedException() {
    }

    public AdvisorAlreadyAssignedException(String message) {
        super(message);
    }
}
