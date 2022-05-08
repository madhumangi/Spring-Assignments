package com.hotelapp.dao;

import java.util.List;

import com.hotelapp.exceptions.HotelIdNotFoundException;
import com.hotelapp.model.Hotel;

public interface IHotelDAO {
	void addHotel(Hotel hotel);
	void updateHotel(int hotelId,double pricePerDay,float ratings);
	void deleteHotel(int hotelId);
	Hotel findHotelById(int hotelId);
	
	List<Hotel> findAllHotels();
	List<Hotel> findHotelByCity(String city);
	List<Hotel> findHotelByGrade(String grade);
	Hotel findHotelByName(String name);
	
	
}
