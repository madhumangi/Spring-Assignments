package com.domain.hotel.service;

import java.sql.Connection;
import java.util.List;
import java.util.stream.Collectors;

import com.domain.hotel.exceptions.CityNotFoundException;
import com.domain.hotel.exceptions.HotelIdNotFoundException;
import com.domain.hotel.exceptions.HotelNameNotFoundException;
import com.domain.hotel.exceptions.InvalidGradeException;
import com.domain.hotel.model.Hotel;
import com.domain.hotel.repository.IHotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HotelServiceImpl implements IHotelService{

	IHotelRepository iHotelRepository;
	@Autowired
	public HotelServiceImpl(IHotelRepository iHotelRepository) {
		this.iHotelRepository = iHotelRepository;
	}

	@Override
	public void addHotel(Hotel hotel) {
		iHotelRepository.addHotel(hotel);
	}

	@Override
	public void updateHotel(int hotelId, double pricePerDay, float ratings) {
		iHotelRepository.updateHotel(hotelId, pricePerDay, ratings);
	}

	@Override
	public void deleteHotel(int hotelId) {
		iHotelRepository.deleteHotel(hotelId);
	}

	@Override
	public Hotel getHotelById(int hotelId) {
		return iHotelRepository.findHotelById(hotelId);
	}

	@Override
	public List<Hotel> getAllHotels() {
		return iHotelRepository.findAllHotels();
	}

	@Override
	public List<Hotel> getHotelByCity(String city){
		return iHotelRepository.findHotelByCity(city);
	}

	@Override
	public List<Hotel> getHotelByGrade(String grade){
		return iHotelRepository.findHotelByGrade(grade);
	}

	@Override
	public Hotel getHotelByName(String name){
		return iHotelRepository.findHotelByName(name);
	}
}
