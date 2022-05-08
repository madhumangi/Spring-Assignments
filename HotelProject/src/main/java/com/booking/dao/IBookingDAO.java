package com.booking.dao;

import java.util.List;

import com.booking.model.Booking;

public interface IBookingDAO {
	Booking showbookingDetails(long contact);
	void bookNewHotel(Booking book,int hotelId);
	List<Booking> findAllBookings();
}
