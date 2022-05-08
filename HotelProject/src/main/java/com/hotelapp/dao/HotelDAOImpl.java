package com.hotelapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hotelapp.model.Hotel;
import com.hotelapp.util.AllQueries;
import com.hotelapp.util.ConnectionUtil;

public class HotelDAOImpl implements IHotelDAO{
	Hotel hotel=null;
	Connection connection=null;
	@Override
	public void addHotel(Hotel hotel) {
		connection=ConnectionUtil.openConnection();
		PreparedStatement preparestatement=null;
		
		try {
			preparestatement=connection.prepareStatement(AllQueries.addsql);
			preparestatement.setString(1,hotel.getHotelNmae());
			preparestatement.setInt(2,hotel.getHotelId());
			preparestatement.setString(3,hotel.getCity());
			preparestatement.setFloat(4,hotel.getRatings());
			preparestatement.setString(5,hotel.getGrade());
			preparestatement.setDouble(6,hotel.getPricePerDay());
			preparestatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		finally {
			if(preparestatement!=null)
				try {
					preparestatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			ConnectionUtil.closeConnection();
		}
		System.out.println("Hotel added successfully.");
	}

	@Override
	public void updateHotel(int hotelId, double pricePerDay, float ratings) {
		connection=ConnectionUtil.openConnection();
		PreparedStatement preparestatement=null;
		try {
			preparestatement=connection.prepareStatement(AllQueries.updatesql);
			preparestatement.setDouble(1,pricePerDay);
			preparestatement.setFloat(2,ratings);
			preparestatement.setInt(3,hotelId);
			preparestatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(preparestatement!=null)
				try {
					preparestatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			ConnectionUtil.closeConnection();
		}
		System.out.println("Updated successfully.");
	}

	@Override
	public void deleteHotel(int hotelId) {
		connection=ConnectionUtil.openConnection();
		PreparedStatement preparestatement=null;
			try {
				preparestatement=connection.prepareStatement(AllQueries.deletesql);
				preparestatement.setInt(1,hotelId);
				preparestatement.execute();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				if(preparestatement!=null)
					try {
						preparestatement.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				ConnectionUtil.closeConnection();
			}
			System.out.println("Deleted successfully.");
			
	}

	@Override
	public Hotel findHotelById(int hotelId){
		connection=ConnectionUtil.openConnection();
		PreparedStatement preparestatement=null;
		Hotel hotel1=null;
		try {
			preparestatement=connection.prepareStatement(AllQueries.getbyidsql);
			preparestatement.setInt(1,hotelId);
			ResultSet rs=preparestatement.executeQuery();
			if(rs.next()) {
				String hotelname=rs.getString("hotelName");
				int hotelid=rs.getInt("hotelId");
				String city=rs.getString("city");
				float ratings=rs.getFloat("ratings");
				String grade=rs.getString("grade");
				double priceperday=rs.getDouble("pricePerDay");
				hotel1=new Hotel(hotelname, hotelid, city, ratings, grade, priceperday);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return hotel1;
	}

	@Override
	public List<Hotel> findAllHotels(){
		List<Hotel> hotels=new ArrayList<Hotel>();
		connection=ConnectionUtil.openConnection();
		PreparedStatement preparestatement=null;
		try {
			preparestatement=connection.prepareStatement(AllQueries.getallsql);
			ResultSet rs=preparestatement.executeQuery();
			while(rs.next()) {
				String hotelname=rs.getString("hotelName");
				int hotelid=rs.getInt("hotelId");
				String city=rs.getString("city");
				float ratings=rs.getFloat("ratings");
				String grade=rs.getString("grade");
				double priceperday=rs.getDouble("pricePerDay");
				hotel=new Hotel(hotelname, hotelid, city, ratings, grade, priceperday);
				hotels.add(hotel);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return hotels;
	}

	@Override
	public List<Hotel> findHotelByCity(String city) {
		List<Hotel> hotels=new ArrayList<Hotel>();
		connection=ConnectionUtil.openConnection();
		PreparedStatement preparestatement=null;
		try {
			preparestatement=connection.prepareStatement(AllQueries.hotelbycitysql);
			preparestatement.setString(1, city);
			ResultSet rs=preparestatement.executeQuery();
			while(rs.next()) {
				String hotelname=rs.getString("hotelName");
				int hotelid=rs.getInt("hotelId");
				float ratings=rs.getFloat("ratings");
				String grade=rs.getString("grade");
				double priceperday=rs.getDouble("pricePerDay");
				hotel=new Hotel(hotelname, hotelid, city, ratings, grade, priceperday);
				hotels.add(hotel);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return hotels;
	}

	@Override
	public List<Hotel> findHotelByGrade(String grade) {
		List<Hotel> hotels=new ArrayList<Hotel>();
		connection=ConnectionUtil.openConnection();
		PreparedStatement preparestatement=null;
		try {
			preparestatement=connection.prepareStatement(AllQueries.hotelbygradesql);
			preparestatement.setString(1, grade);
			ResultSet rs=preparestatement.executeQuery();
			while(rs.next()) {
				String hotelname=rs.getString("hotelName");
				int hotelid=rs.getInt("hotelId");
				String city=rs.getString("city");
				float ratings=rs.getFloat("ratings");
				double priceperday=rs.getDouble("pricePerDay");
				hotel=new Hotel(hotelname, hotelid, city, ratings, grade, priceperday);
				hotels.add(hotel);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return hotels;
	}

	@Override
	public Hotel findHotelByName(String name) {
		connection=ConnectionUtil.openConnection();
		PreparedStatement preparestatement=null;
		try {
			preparestatement=connection.prepareStatement(AllQueries.hotelbynamesql);
			preparestatement.setString(1, name);
			ResultSet rs=preparestatement.executeQuery();
			while(rs.next()) {
				String hotelname=rs.getString("hotelName");
				int hotelid=rs.getInt("hotelId");
				String city=rs.getString("city");
				float ratings=rs.getFloat("ratings");
				String grade=rs.getString("grade");
				double priceperday=rs.getDouble("pricePerDay");
				hotel=new Hotel(hotelname, hotelid, city, ratings, grade, priceperday);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return hotel;
	
	}
	
}
