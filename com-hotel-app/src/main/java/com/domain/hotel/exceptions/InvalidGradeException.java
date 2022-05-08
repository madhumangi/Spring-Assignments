package com.domain.hotel.exceptions;

public class InvalidGradeException extends RuntimeException {
    public InvalidGradeException() {
    }

    public InvalidGradeException(String message) {
        super(message);
    }
}
