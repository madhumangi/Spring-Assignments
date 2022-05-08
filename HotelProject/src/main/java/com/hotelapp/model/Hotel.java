package com.hotelapp.model;

public class Hotel {
	String hotelName;
	Integer hotelId;
	String city;
	float ratings;
	String grade;
	double pricePerDay;
	
	public Hotel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Hotel(String hotelName, Integer hotelId, String city, float ratings, String grade, double pricePerDay) {
		super();
		this.hotelName = hotelName;
		this.hotelId = hotelId;
		this.city = city;
		this.ratings = ratings;
		this.grade = grade;
		this.pricePerDay = pricePerDay;
	}
	public String getHotelNmae() {
		return hotelName;
	}
	public void setHotelNmae(String hotelNmae) {
		this.hotelName = hotelNmae;
	}
	public Integer getHotelId() {
		return hotelId;
	}
	public void setHotelId(Integer hotelId) {
		this.hotelId = hotelId;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public float getRatings() {
		return ratings;
	}
	public void setRatings(float ratings) {
		this.ratings = ratings;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public double getPricePerDay() {
		return pricePerDay;
	}
	public void setPricePerDay(double pricePerDay) {
		this.pricePerDay = pricePerDay;
	}
	@Override
	public String toString() {
		return "\n Hotel [Hotel Name=" + hotelName + ", Hotel Id=" + hotelId + ", City=" + city + ", Ratings=" + ratings
				+ ", Grade=" + grade + ", Price Per Day=" + pricePerDay + "]";
	}
	
}
