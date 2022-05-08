package com.hotelapp.jpa.hotel.service;
import com.hotelapp.jpa.hotel.model.Hotel;
import com.hotelapp.jpa.hotel.repository.IHotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelServiceImpl implements IHotelService{

	IHotelRepository iHotelRepository;
	@Autowired
	public HotelServiceImpl(IHotelRepository iHotelRepository) {
		this.iHotelRepository = iHotelRepository;
	}

	@Override
	public void addHotel(Hotel hotel) {
		iHotelRepository.save(hotel);
	}

	@Override
	public void updateHotel(Hotel hotel) {
		iHotelRepository.save(hotel);
	}

	@Override
	public void deleteHotel(int hotelId) {
		iHotelRepository.deleteById(hotelId);
	}

	@Override
	public Hotel getHotelById(int hotelId) {
		return iHotelRepository.findHotelById(hotelId);
	}

//	@Override
//	public List<Hotel> getAllHotels() {
//		return iHotelRepository.findAllHotels();
//	}

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
