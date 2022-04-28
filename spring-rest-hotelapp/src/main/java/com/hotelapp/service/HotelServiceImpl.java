package com.hotelapp.service;

import com.hotelapp.exceptions.HotelNotFoundException;
import com.hotelapp.model.Hotel;
import com.hotelapp.repository.IHotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
@Service
public class HotelServiceImpl implements IHotelService{

    @Autowired
    private IHotelRepository hotelRepository;

    @Override
    public void addHotel(Hotel hotel) {
        hotelRepository.save(hotel);
    }

    @Override
    public void updateHotel(Hotel hotel) {
        hotelRepository.save(hotel);
    }

    @Override
    public void deleteHotel(int hotelId) {
        hotelRepository.deleteById(hotelId);
    }

    @Override
    public Hotel getHotelById(int hotelId)  throws HotelNotFoundException {
        Hotel hotel=hotelRepository.findById(hotelId).get();
        if(hotel!=null)
            return hotel;
        else
            throw new HotelNotFoundException("Id not found");
    }

    @Override
    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    @Override
    public List<Hotel> getHotelByRatingsAndType(double ratings, String type)  throws HotelNotFoundException {
        List<Hotel> hotels=hotelRepository.findHotelByRatingsAndType(ratings, type);
        if(hotels.isEmpty())
            throw new HotelNotFoundException("Hotel Not Found");
        else
            return hotels;
    }

    @Override
    public List<Hotel> getHotelByCityAndDistance(String city, String distance) throws HotelNotFoundException {
        List<Hotel> hotels=hotelRepository.findHotelByCityAndDistance(city, distance);
        if(hotels.isEmpty())
            throw new HotelNotFoundException("Hotel Not Found");
        else
            return hotels;
    }

    @Override
    public List<Hotel> getByPriceLessThan(double price)  throws HotelNotFoundException{
        List<Hotel> hotels=hotelRepository.findByPriceLessThan(price);
        if(hotels.isEmpty())
            throw new HotelNotFoundException("Hotel Not Found");
        else
            return hotels;
    }

    @Override
    public List<Hotel> getByRestaurantIncluded(boolean restaurantIncluded)  throws HotelNotFoundException{
        List<Hotel> hotels=hotelRepository.findByRestaurantIncluded(restaurantIncluded);
        if(hotels.isEmpty())
            throw new HotelNotFoundException("Hotel Not Found");
        else
            return hotels;
    }

    @Override
    public List<Hotel> getByPropertyTypeAndTotalNoOfRooms(String propertyType, int totalNoOfRooms)  throws HotelNotFoundException{
        List<Hotel> hotels=hotelRepository.findByPropertyTypeAndTotalNoOfRooms(propertyType, totalNoOfRooms);
        if(hotels.isEmpty())
            throw new HotelNotFoundException("Hotel Not Found");
        else
            return hotels;
    }

    @Override
    public List<Hotel> getByCheckInDateLessThan(LocalDate checkInDate)  throws HotelNotFoundException{
        List<Hotel> hotels=hotelRepository.findByCheckInDateLessThan(checkInDate);
    if(hotels.isEmpty())
            throw new HotelNotFoundException("Hotel Not Found");
        else
                return hotels;
    }

    @Override
    public List<Hotel> getByCheckOutDateLessThan(LocalDate checkOutDate)  throws HotelNotFoundException{
        List<Hotel> hotels=hotelRepository.findByCheckOutDateLessThan(checkOutDate);
    if(hotels.isEmpty())
            throw new HotelNotFoundException("Hotel Not Found");
        else
                return hotels;
    }
}
