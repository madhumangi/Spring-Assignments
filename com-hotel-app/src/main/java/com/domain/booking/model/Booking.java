package com.domain.booking.model;

import lombok.*;

import java.time.LocalDate;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Booking {
    int bookingId;
    int hotelId;
    String customerName;
    LocalDate checkInDate;
    LocalDate checkOutDate;
    int noOfPersons;
    long totalNoOfDays;
    long contact;
    double totalAmount;
    boolean breakfast;
}
