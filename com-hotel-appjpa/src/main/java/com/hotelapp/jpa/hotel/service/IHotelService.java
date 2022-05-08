package com.hotelapp.jpa.hotel.service;

import com.hotelapp.jpa.hotel.exceptions.CityNotFoundException;
import com.hotelapp.jpa.hotel.exceptions.InvalidGradeException;
import com.hotelapp.jpa.hotel.exceptions.HotelIdNotFoundException;
import com.hotelapp.jpa.hotel.exceptions.HotelNameNotFoundException;

import com.hotelapp.jpa.hotel.exceptions.CityNotFoundException;
import com.hotelapp.jpa.hotel.exceptions.HotelIdNotFoundException;
import com.hotelapp.jpa.hotel.exceptions.HotelNameNotFoundException;
import com.hotelapp.jpa.hotel.exceptions.InvalidGradeException;
import com.hotelapp.jpa.hotel.model.Hotel;

import java.util.List;

public interface IHotelService {

	void addHotel(Hotel hotel);
	void updateHotel(Hotel hotel );
	void deleteHotel(int hotelId);

	Hotel getHotelById(int hotelId) throws HotelIdNotFoundException;

//	List<Hotel> getAllHotels();
	List<Hotel> getHotelByCity(String city) throws CityNotFoundException;
	List<Hotel> getHotelByGrade(String grade) throws InvalidGradeException;
	Hotel getHotelByName(String name) throws HotelNameNotFoundException;
	
}
