package com.domain.hotel.repository;

import com.domain.hotel.model.Hotel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class HotelMapper implements RowMapper<Hotel> {
    @Override
    public Hotel mapRow(ResultSet rs, int rowNum) throws SQLException {
        Hotel hotel = new Hotel();
        hotel.setHotelName(rs.getString("hotelname"));
        hotel.setHotelId(rs.getInt("hotelid"));
        hotel.setCity(rs.getString("city"));
        hotel.setRatings(rs.getFloat("ratings"));
        hotel.setGrade(rs.getString("grade"));
        hotel.setPricePerDay(rs.getDouble("priceperday"));
        return hotel;
    }
}
