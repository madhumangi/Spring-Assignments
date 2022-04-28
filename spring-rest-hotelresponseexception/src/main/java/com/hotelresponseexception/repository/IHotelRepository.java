package com.hotelresponseexception.repository;


import com.hotelresponseexception.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
@Repository
public interface IHotelRepository extends JpaRepository<Hotel,Integer> {
    @Query("from Hotel h where h.ratings=?1 and h.type=?2")
    List<Hotel> findHotelByRatingsAndType(double ratings, String type);
    @Query("from Hotel h where h.city=?1 and h.distance=?2")
    List<Hotel> findHotelByCityAndDistance(String city,String distance);
    @Query("from Hotel h where h.price<?1")
    List<Hotel> findByPriceLessThan(double price);
    @Query("from Hotel h where h.restaurantIncluded=?1")
    List<Hotel> findByRestaurantIncluded(boolean restaurantIncluded);
    @Query("from Hotel h where h.propertyType=?1 and totalNoOfRooms<?2")
    List<Hotel> findByPropertyTypeAndTotalNoOfRooms(String propertyType,int totalNoOfRooms);
    @Query("from Hotel h where h.checkIn<?1")
    List<Hotel> findByCheckInDateLessThan(LocalDate checkInDate);
    @Query("from Hotel h where h.checkOut<?1")
    List<Hotel> findByCheckOutDateLessThan(LocalDate checkOutDate);





}
