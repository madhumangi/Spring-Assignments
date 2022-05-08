package com.hotelapp.jpa.hotel.exceptions;

public class HotelIdNotFoundException extends RuntimeException {
    public HotelIdNotFoundException() {
    }

    public HotelIdNotFoundException(String message) {
        super(message);
    }
}
