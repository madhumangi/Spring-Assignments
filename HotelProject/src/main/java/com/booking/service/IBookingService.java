package com.booking.service;

import java.util.List;

import com.booking.model.Booking;
import com.hotelapp.exceptions.BookingIdNotFoundException;

public interface IBookingService {
	void bookHotel(Booking book,int hotelId);
	Booking bookingDetails(long contact) throws BookingIdNotFoundException;
	
	List<Booking> getAllBookings();
}
