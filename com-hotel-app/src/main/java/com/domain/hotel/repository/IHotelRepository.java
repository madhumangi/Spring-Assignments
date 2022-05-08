package com.domain.hotel.repository;

import com.domain.hotel.model.Hotel;
import org.springframework.stereotype.Repository;

import java.util.List;
public interface IHotelRepository {
    void addHotel(Hotel hotel);
    void updateHotel(int hotelId,double pricePerDay,float ratings);
    void deleteHotel(int hotelId);
    Hotel findHotelById(int hotelId);

    List<Hotel> findAllHotels();
    List<Hotel> findHotelByCity(String city);
    List<Hotel> findHotelByGrade(String grade);
    Hotel findHotelByName(String name);
}
