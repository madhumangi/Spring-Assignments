package com.domain.booking.repository;

import com.domain.booking.model.Booking;

import java.util.List;

public interface IBookingRepository {
    Booking showBookingDetails(long contact);
    void bookNewHotel(Booking book,int hotelId);
    List<Booking> findAllBookings();
}
