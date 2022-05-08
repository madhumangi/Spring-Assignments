package com.domain.hotel.repository;

import com.domain.hotel.model.Hotel;
import com.domain.hotel.util.AllQueries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository

public class HotelRepositoryImpl implements IHotelRepository{
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Override
    public void addHotel(Hotel hotel) {
        Object[] hotels = {hotel.getHotelName(),hotel.getHotelId(),hotel.getCity(),hotel.getRatings(),hotel.getGrade(),hotel.getPricePerDay()};
        jdbcTemplate.update(AllQueries.ADDSQL,hotels);
    }

    @Override
    public void updateHotel(int hotelId, double pricePerDay, float ratings) {
        jdbcTemplate.update(AllQueries.UPDATESQL,hotelId,pricePerDay,ratings);

    }
    @Override
    public void deleteHotel(int hotelId) {
        jdbcTemplate.update(AllQueries.DELETESQL,hotelId);

    }

    @Override
    public Hotel findHotelById(int hotelId) {
        return jdbcTemplate.queryForObject(AllQueries.GETBYIDSQL,new HotelMapper(),hotelId);
    }

    @Override
    public List<Hotel> findAllHotels() {
        return jdbcTemplate.query(AllQueries.GETALLSQL,new HotelMapper());

    }

    @Override
    public List<Hotel> findHotelByCity(String city) {
        return jdbcTemplate.query(AllQueries.HOTELBYCITYSQL,new HotelMapper(),city);

    }

    @Override
    public List<Hotel> findHotelByGrade(String grade) {
        return jdbcTemplate.query(AllQueries.HOTELBYGRADESQL,new HotelMapper(),grade);

    }

    @Override
    public Hotel findHotelByName(String name) {
        return jdbcTemplate.queryForObject(AllQueries.HOTELBYNAMESQL,new HotelMapper(),name);

    }
}
