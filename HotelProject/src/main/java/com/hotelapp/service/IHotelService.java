package com.hotelapp.service;

import java.util.List;

import com.hotelapp.exceptions.CityNotFoundException;
import com.hotelapp.exceptions.HotelIdNotFoundException;
import com.hotelapp.exceptions.HotelNameNotFoundException;
import com.hotelapp.exceptions.InvalidGradeException;
import com.hotelapp.model.Hotel;

public interface IHotelService {

	void addHotel(Hotel hotel);
	void updateHotel(int hotelId,double pricePerDay,float ratings );
	void deleteHotel(int hotelId);
	Hotel getHotelById(int hotelId) throws HotelIdNotFoundException;
	
	List<Hotel> getAllHotels();
	List<Hotel> getHotelByCity(String city) throws CityNotFoundException;
	List<Hotel> getHotelByGrade(String grade) throws InvalidGradeException;
	Hotel getHotelByName(String name) throws HotelNameNotFoundException;
	
}
