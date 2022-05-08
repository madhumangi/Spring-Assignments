package com.domain.hotel.exceptions;

public class HotelNameNotFoundException extends RuntimeException {
    public HotelNameNotFoundException() {
    }

    public HotelNameNotFoundException(String message) {
        super(message);
    }
}
