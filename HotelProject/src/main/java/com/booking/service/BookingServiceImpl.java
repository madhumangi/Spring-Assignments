package com.booking.service;

import java.util.ArrayList;
import java.util.List;

import com.booking.dao.BookingDAOImpl;
import com.booking.dao.IBookingDAO;
import com.booking.model.Booking;
import com.hotelapp.exceptions.BookingIdNotFoundException;

public class BookingServiceImpl implements IBookingService{

	private IBookingDAO bookingdao=new BookingDAOImpl();
	@Override
	public Booking bookingDetails(long contact) throws BookingIdNotFoundException {
		Booking details=bookingdao.showbookingDetails(contact);
		if(details==null)
			throw new BookingIdNotFoundException("Booking Id"+contact+" not found.");
		return details;
	}

	@Override
	public void bookHotel(Booking book,int hotelId) {
		bookingdao.bookNewHotel(book,hotelId);
	}

	@Override
	public List<Booking> getAllBookings() {
		List<Booking> allbookings=new ArrayList<Booking>();
		allbookings=bookingdao.findAllBookings();
		return allbookings;
	}
	
}
