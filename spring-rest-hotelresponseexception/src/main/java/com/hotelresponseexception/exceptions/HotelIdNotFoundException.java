package com.hotelresponseexception.exceptions;

public class HotelIdNotFoundException extends RuntimeException {
    public HotelIdNotFoundException(String message) {
        super(message);
    }
}
