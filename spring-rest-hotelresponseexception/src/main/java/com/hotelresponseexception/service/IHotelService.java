package com.hotelresponseexception.service;




import com.hotelresponseexception.exceptions.HotelIdNotFoundException;
import com.hotelresponseexception.exceptions.HotelNotFoundException;
import com.hotelresponseexception.model.Hotel;

import java.time.LocalDate;
import java.util.List;

public interface IHotelService {
    void addHotel(Hotel hotel);
    void updateHotel(Hotel hotel );
    void deleteHotel(int hotelId);

    Hotel getHotelById(int hotelId) throws HotelIdNotFoundException;

    List<Hotel> getAllHotels();


    List<Hotel> getHotelByRatingsAndType(double ratings,String type) throws HotelNotFoundException;
    List<Hotel> getHotelByCityAndDistance(String city,String distance) throws HotelNotFoundException;
    List<Hotel> getByPriceLessThan(double price) throws HotelNotFoundException;
    List<Hotel> getByRestaurantIncluded(boolean restaurantIncluded);
    List<Hotel> getByPropertyTypeAndTotalNoOfRooms(String propertyType,int totalNoOfRooms) throws HotelNotFoundException;
    List<Hotel> getByCheckInDateLessThan(LocalDate checkInDate) throws HotelNotFoundException;
    List<Hotel> getByCheckOutDateLessThan(LocalDate checkOutDate) throws HotelNotFoundException;




}
