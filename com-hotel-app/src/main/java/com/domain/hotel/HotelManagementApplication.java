package com.domain.hotel;

import com.domain.hotel.model.Hotel;
import com.domain.hotel.service.IHotelService;
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
		Hotel hotel=new Hotel("Novotel",115,"Hyderabad", 9.9f,"5 star",25000);
//		iHotelService.addHotel(hotel);
//		iHotelService.updateHotel(115,21000,10.0f);
//		iHotelService.deleteHotel(115);

//		System.out.println(iHotelService.getHotelById(115));
//		iHotelService.getAllHotels().forEach(System.out::println);
//		iHotelService.getHotelByCity("Hyderabad").forEach(System.out::println);
//		iHotelService.getHotelByGrade("4 star").forEach(System.out::println);
		System.out.println(iHotelService.getHotelByName("Bloom"));

	}
}
