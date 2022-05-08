package com.hotelapp.service;

import java.sql.Connection;
import java.util.List;
import java.util.stream.Collectors;

import com.hotelapp.dao.HotelDAOImpl;
import com.hotelapp.dao.IHotelDAO;
import com.hotelapp.exceptions.CityNotFoundException;
import com.hotelapp.exceptions.HotelIdNotFoundException;
import com.hotelapp.exceptions.HotelNameNotFoundException;
import com.hotelapp.exceptions.InvalidGradeException;
import com.hotelapp.model.Hotel;

public class HotelServiceImpl implements IHotelService{
	IHotelDAO hoteldao=new HotelDAOImpl();
	Connection connection=null;
	@Override
	public void addHotel(Hotel hotel) {
		hoteldao.addHotel(hotel);
	}

	@Override
	public void updateHotel(int hotelId, double pricePerDay, float ratings) {
		hoteldao.updateHotel(hotelId, pricePerDay, ratings);
	}

	@Override
	public void deleteHotel(int hotelId) {
		hoteldao.deleteHotel(hotelId);
	}

	@Override
	public Hotel getHotelById(int hotelId) throws HotelIdNotFoundException {
		Hotel hotel=hoteldao.findHotelById(hotelId);
		if(hotel==null)
			throw new HotelIdNotFoundException("Hotel id "+hotelId+" not found.");
		return hotel;
	}

	@Override
	public List<Hotel> getAllHotels() {
		List<Hotel> hotels=hoteldao.findAllHotels();
		return hotels.stream().sorted((hotel1,hotel2)->hotel1.getCity().compareTo(hotel2.getCity())).collect(Collectors.toList());
	}

	@Override
	public List<Hotel> getHotelByCity(String city) throws CityNotFoundException {
		List<Hotel> hotelbycity=hoteldao.findHotelByCity(city);
		if(hotelbycity.isEmpty())
			throw new CityNotFoundException("Hotel in "+city+" not found.");
		return hotelbycity.stream().sorted((hotel1,hotel2)->hotel1.getCity().compareTo(hotel2.getCity())).collect(Collectors.toList());
	}

	@Override
	public List<Hotel> getHotelByGrade(String grade) throws InvalidGradeException {
		List<Hotel> hotelbygrade=hoteldao.findHotelByGrade(grade);
		if(hotelbygrade.isEmpty())
			throw new InvalidGradeException("Grade "+grade+" not found.");
		return hotelbygrade.stream().sorted((hotel1,hotel2)->hotel1.getCity().compareTo(hotel2.getCity())).collect(Collectors.toList());
	}

	@Override
	public Hotel getHotelByName(String name) throws HotelNameNotFoundException {
		Hotel getbyname=hoteldao.findHotelByName(name);
		if(getbyname==null)
			throw new HotelNameNotFoundException("Hotel name "+name+" not found.");
		return null;
	}

}
