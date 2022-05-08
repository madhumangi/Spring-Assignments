package com.domain.hotel.service;

import java.util.List;

import com.domain.hotel.exceptions.CityNotFoundException;
import com.domain.hotel.exceptions.HotelIdNotFoundException;
import com.domain.hotel.exceptions.HotelNameNotFoundException;
import com.domain.hotel.exceptions.InvalidGradeException;
import com.domain.hotel.model.Hotel;

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
