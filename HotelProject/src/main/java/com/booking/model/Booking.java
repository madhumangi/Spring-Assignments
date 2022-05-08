package com.booking.model;

import java.time.LocalDate;

public class Booking {
	int bookingId;
	int hotelId;
	String customerName;
	LocalDate checkInDate;
	LocalDate checkOutDate;
	int noOfPersons;
	long totalNoOfDays;
	long contact;
	
	double totalamount;
	boolean breakfast;
	
	
	public Booking(int bookingId, int hotelId, String customerName, LocalDate dateCheckIn, LocalDate dateCheckOut,
			int noOfPersons, long totalNoOfDays, long contact, double totalamount, boolean breakfast) {
		super();
		this.bookingId = bookingId;
		this.hotelId = hotelId;
		this.customerName = customerName;
		this.checkInDate = dateCheckIn;
		this.checkOutDate = dateCheckOut;
		this.noOfPersons = noOfPersons;
		this.totalNoOfDays = totalNoOfDays;
		this.contact = contact;
		this.totalamount = totalamount;
		this.breakfast = breakfast;
	}


	public Booking(String customerName, LocalDate checkInDate, LocalDate checkOutDate, int noOfPersons, long contact,
			boolean breakfast) {
		super();
		this.customerName = customerName;
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
		this.noOfPersons = noOfPersons;
		this.contact = contact;
		this.breakfast = breakfast;
	}
	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public LocalDate getCheckInDate() {
		return checkInDate;
	}
	public void setCheckInDate(LocalDate checkInDate) {
		this.checkInDate = checkInDate;
	}
	public LocalDate getCheckOutDate() {
		return checkOutDate;
	}
	public void setCheckOutDate(LocalDate checkOutDate) {
		this.checkOutDate = checkOutDate;
	}
	public int getNoOfPersons() {
		return noOfPersons;
	}
	public void setNoOfPersons(int noOfPersons) {
		this.noOfPersons = noOfPersons;
	}
	public long getContact() {
		return contact;
	}
	public void setContact(long contact) {
		this.contact = contact;
	}
	
	public double getTotalamount() {
		return totalamount;
	}
	public void setTotalamount(double totalamount) {
		this.totalamount = totalamount;
	}
	public boolean getBreakfast() {
		return breakfast;
	}
	public void setBreakfast(boolean breakfast) {
		this.breakfast = breakfast;
	}
	
	public int getHotelId() {
		return hotelId;
	}


	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}


	@Override
	public String toString() {
		return "\nBooking [bookingId=" + bookingId + ", customerName=" + customerName + ", checkInDate=" + checkInDate
				+ ", checkOutDate=" + checkOutDate + ", noOfPersons=" + noOfPersons + ", totalNoOfDays=" + totalNoOfDays
				+ ", contact=" + contact + ",totalamount=" + totalamount
				+ ", breakfast=" + breakfast + "]";
	}
	
}
