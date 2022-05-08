package com.hotelapp.jpa.hotel.repository;

import com.hotelapp.jpa.hotel.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IHotelRepository extends JpaRepository<Hotel,Integer> {
    Hotel findHotelById(int hotelId);

//    List<Hotel> findAllHotels();
    List<Hotel> findHotelByCity(String city);
    List<Hotel> findHotelByGrade(String grade);
    Hotel findHotelByName(String name);
}
