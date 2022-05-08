package com.domain.booking.repository;

import com.domain.booking.model.Booking;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class BookingRepositoryImpl implements IBookingRepository{


    @Override
    public Booking showBookingDetails(long contact) {
        return null;
    }

    @Override
    public void bookNewHotel(Booking book, int hotelId) {

    }

    @Override
    public List<Booking> findAllBookings() {
        return null;
    }
}
