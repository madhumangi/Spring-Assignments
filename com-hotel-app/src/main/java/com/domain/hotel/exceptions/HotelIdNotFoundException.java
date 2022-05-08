package com.domain.hotel.exceptions;

public class HotelIdNotFoundException extends RuntimeException {
    public HotelIdNotFoundException() {
    }

    public HotelIdNotFoundException(String message) {
        super(message);
    }
}
