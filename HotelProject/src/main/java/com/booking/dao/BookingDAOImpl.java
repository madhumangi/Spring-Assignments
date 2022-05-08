package com.booking.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import com.booking.model.Booking;
import com.hotelapp.model.Hotel;
import com.hotelapp.util.AllQueries;
import com.hotelapp.util.ConnectionUtil;

public class BookingDAOImpl implements IBookingDAO{
	private static Connection connection=null;
	
	@Override
	public Booking showbookingDetails(long contact) {
		connection=ConnectionUtil.openConnection();
		Hotel hotel=new Hotel();
		PreparedStatement preparestatement=null;
		Booking showdetails=null;
		try {
			preparestatement=connection.prepareStatement(AllQueries.SHOWQUERY);
			preparestatement.setLong(1,contact);
			ResultSet rs=preparestatement.executeQuery();
			while(rs.next()) {
				int bookingid=rs.getInt("bookingId");
				String custname=rs.getString("customername");
				LocalDate checkindate=rs.getDate("checkindate").toLocalDate();
				LocalDate checkoutdate=rs.getDate("checkoutdate").toLocalDate();
				int noofpersons=rs.getInt("noofpersons");
				int hotelid=rs.getInt("hotelid");
				long totalnoofdays=calctotaldays(checkindate,checkoutdate);
				//long contact1=rs.getLong("contact");
				double totalamount=calcAmount(totalnoofdays,hotel.getPricePerDay());
				showdetails=new Booking(bookingid, hotelid,custname, checkindate, checkoutdate, noofpersons, totalnoofdays, contact, totalamount, false);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(preparestatement!=null)
				try {
					preparestatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				ConnectionUtil.closeConnection();
		}	
		
		
		return showdetails;
	}

	private double calcAmount(long totalnoofdays, double pricePerDay) {
		return (totalnoofdays*pricePerDay)+215;
	}

	private long calctotaldays(LocalDate checkindate, LocalDate checkoutdate) {
		long totalNoOfDays=ChronoUnit.DAYS.between(checkindate,checkoutdate);
		return totalNoOfDays;
	}

	@Override
	public void bookNewHotel(Booking book,int hotelId) {
		connection=ConnectionUtil.openConnection();
		PreparedStatement preparestatement=null;
		try {
			preparestatement=connection.prepareStatement(AllQueries.INSERTQUERY);
			preparestatement.setString(1,book.getCustomerName());
			Date bookingDate1 = Date.valueOf(book.getCheckInDate());
			preparestatement.setDate(2, bookingDate1);
			Date bookingDate2 = Date.valueOf(book.getCheckOutDate());
			preparestatement.setDate(3, bookingDate2);
			preparestatement.setInt(4,book.getNoOfPersons());
			preparestatement.setLong(5,book.getContact());
			preparestatement.setBoolean(6, book.getBreakfast());
			preparestatement.setInt(7, hotelId);
			long totalnoofdays=calctotaldays(book.getCheckInDate(),book.getCheckOutDate());
			preparestatement.setLong(8, totalnoofdays);
			preparestatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(preparestatement!=null)
				try {
					preparestatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				ConnectionUtil.closeConnection();
		}	
		
		
		System.out.println("Booking successful.");
	}

	@Override
	public List<Booking> findAllBookings() {
		connection=ConnectionUtil.openConnection();
		Hotel hotel=new Hotel();
		List<Booking> bookings=new ArrayList<Booking>();
		Booking bookedslot=null;
		PreparedStatement preparestatement=null;
		try {
		preparestatement=connection.prepareStatement(AllQueries.ALLBOOKINGSQUERY);
		ResultSet rs = preparestatement.executeQuery();
		while(rs.next()) {
			int bookingid=rs.getInt("bookingId");
			int hotelid=rs.getInt("hotelid");
			String custname=rs.getString("customername");
			LocalDate checkindate=rs.getDate("checkindate").toLocalDate();
			LocalDate checkoutdate=rs.getDate("checkoutdate").toLocalDate();
			int noofpersons=rs.getInt("noofpersons");
			long totalnoofdays=calctotaldays(checkindate,checkoutdate);
			long contact=rs.getLong("contact");
			double totalamount=calcAmount(totalnoofdays,hotel.getPricePerDay());
			boolean breakfast=rs.getBoolean("breakfast");
			bookedslot=new Booking(bookingid, hotelid,custname, checkindate, checkoutdate, noofpersons, totalnoofdays, contact, totalamount, breakfast);
			bookings.add(bookedslot);
		}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(preparestatement!=null)
				try {
					preparestatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				ConnectionUtil.closeConnection();
		}	
		
		return bookings;
	}
	
}
