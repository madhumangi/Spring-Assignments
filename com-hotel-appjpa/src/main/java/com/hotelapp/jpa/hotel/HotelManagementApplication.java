package com.hotelapp.jpa.hotel;

import com.hotelapp.jpa.hotel.model.Grade;
import com.hotelapp.jpa.hotel.model.Hotel;
import com.hotelapp.jpa.hotel.service.IHotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HotelManagementApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(HotelManagementApplication.class, args);
	}
		@Autowired
		IHotelService iHotelService;
	@Override
	public void run(String... args) throws Exception {
		//Display hotels
//		iHotelService.getAllHotels().forEach(System.out::println);
		//Add hotel
		Hotel hotel=new Hotel("Novotel","Hyderabad", 9.9f, Grade.FIVE,25000);
		Hotel hotel1=new Hotel("ITC Kohenur","Hyderabad", 10.0f, Grade.FIVE,30000);
		Hotel hotel2=new Hotel("Ibis","Hyderabad", 9.2f, Grade.FOUR,2500);
		Hotel hotel3=new Hotel("Bloom","Hyderabad", 7.1f, Grade.THREE,1500);
		Hotel hotel4=new Hotel("Westin","Hyderabad", 10.0f, Grade.FIVE,10000);
//		iHotelService.addHotel(hotel);
//		iHotelService.addHotel(hotel1);
//		iHotelService.addHotel(hotel2);
//		iHotelService.addHotel(hotel3);
//		iHotelService.addHotel(hotel4);

		Hotel hotel5=new Hotel("Novotel","Hyderabad", 10.0f, Grade.FIVE,15000);
//		iHotelService.updateHotel(hotel5);
//		iHotelService.deleteHotel(7);
//		System.out.println(iHotelService.getHotelById(4));



		iHotelService.getHotelByCity("Hyderabad").forEach(System.out::println);
		iHotelService.getHotelByGrade("4 star").forEach(System.out::println);
		System.out.println(iHotelService.getHotelByName("Bloom"));

	}
}
