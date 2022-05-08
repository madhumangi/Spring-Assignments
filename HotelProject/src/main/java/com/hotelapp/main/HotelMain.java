package com.hotelapp.main;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import com.booking.model.Booking;
import com.booking.service.BookingServiceImpl;
import com.booking.service.IBookingService;
import com.hotelapp.exceptions.BookingIdNotFoundException;
import com.hotelapp.exceptions.CityNotFoundException;
import com.hotelapp.exceptions.HotelIdNotFoundException;
import com.hotelapp.exceptions.InvalidGradeException;
import com.hotelapp.model.Grade;
import com.hotelapp.model.Hotel;
import com.hotelapp.service.HotelServiceImpl;
import com.hotelapp.service.IHotelService;

public class HotelMain {
	public static void main(String[] args) {
		String hotelname;
		int hotelid;
		String city;
		float ratings;
		String grade;
		double priceperday;
		String admin="Maggi";
		String name;
		String password="2702";
		String pwd;
		int login;
		int choice;
		Scanner scanner=new Scanner(System.in);
		IHotelService hotelservice=new HotelServiceImpl();
		IBookingService bookingservice=new BookingServiceImpl();
		Hotel hotel=null;
		Booking booking=null;
		
		System.out.println("Select:\n\t1.Admin Login.\n\t2.Customer Login");
		login=scanner.nextInt();
		if(login==1) {
			System.out.println("Enter you name to continue:");
			name=scanner.next();
			System.out.println("Enter the password:");
			pwd=scanner.next();
			if(name.equalsIgnoreCase(admin) && pwd.equalsIgnoreCase(password)) {
				do {
				System.out.println("Select operation from below to perform:");
				System.out.println("\t\t1.Add new hotel.\n\t\t2.Update existing hotel details.\n\t\t3.Delete hotel.\n\t\t4.Get hotel by id.\n\t\t5.Get all bookings.\n\t\t6.Exit");
				choice=scanner.nextInt();
				switch(choice) {
				case 1:
					scanner.nextLine();
					System.out.println("Enter the hotel name:");
					hotelname=scanner.nextLine();
					System.out.println("Enter the hotel id:");
					hotelid=scanner.nextInt();
					scanner.nextLine();
					System.out.println("Enter the city:");
					city=scanner.nextLine();
					System.out.println("Enter rating:");
					ratings=scanner.nextFloat();
					scanner.nextLine();
					System.out.println("Enter the grade:(ONE/TWO/THREE/FOUR/FIVE)");
					grade=scanner.nextLine();
					if (grade.equalsIgnoreCase("ONE")) {
						grade = Grade.ONE.grade;
					}
					if (grade.equalsIgnoreCase("TWO")) {
						grade = Grade.TWO.name();
					}
					if (grade.equalsIgnoreCase("THREE")) {
						grade = Grade.THREE.name();
					}
					if (grade.equalsIgnoreCase("FOUR")) {
						grade = Grade.FOUR.name();
					}
					if (grade.equalsIgnoreCase("FIVE")) {
						grade = Grade.FIVE.name();
					}
					System.out.println("Enter the price per day:");
					priceperday=scanner.nextDouble();
					hotel=new Hotel(hotelname, hotelid, city, ratings, grade, priceperday);
					hotelservice.addHotel(hotel);
					break;
				case 2:
					System.out.println("Enter the hotel id of which you want to update:");
					hotelid=scanner.nextInt();
					System.out.println("Enter the updated price:");
					priceperday=scanner.nextDouble();
					System.out.println("Enter the updated ratings:");
					ratings=scanner.nextFloat();
					hotelservice.updateHotel(hotelid, priceperday, ratings);
					break;
				case 3:
					System.out.println("Enter the hotel id:");
					hotelid=scanner.nextInt();
					hotelservice.deleteHotel(hotelid);
					break;
				case 4:
					System.out.println("Enter the hotelid:");
					hotelid=scanner.nextInt();
					try {
						System.out.println(hotelservice.getHotelById(hotelid));
					} catch (HotelIdNotFoundException e) {
						e.printStackTrace();
					}
					break;
				case 5:
					System.out.println(bookingservice.getAllBookings());
					break;
				case 6:
					System.out.println("THANK YOU.");
					continue;
				default:
					System.out.println("Wrong choice.");
					break;
				}	
				}while(choice!=6);
			}
			
		}
		else {
			do {
			System.out.println("Select operation from below to perform:");
			System.out.println("\t\t1.Get details of all hotels.\n\t\t2.Get hotel by city\n\t\t3.Get hotel by grade.\n\t\t4.Book New Hotel.\n\t\t5.Show booking details.\n\t\t6.Exit.");
			choice=scanner.nextInt();
			switch(choice) {
			case 1:
				System.out.println(hotelservice.getAllHotels());
				break;
			case 2:
				System.out.println("Enter the city name:");
				city=scanner.next();
				try {
					System.out.println(hotelservice.getHotelByCity(city));
				} catch (CityNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 3:
				scanner.nextLine();
				System.out.println("Enter the grade from below: 3 star/4 star/5 star");
				grade=scanner.nextLine();
				try {
					System.out.println(hotelservice.getHotelByGrade(grade));
				} catch (InvalidGradeException e) {
					e.printStackTrace();
				}
				break;
			case 4:
				scanner.nextLine();
				System.out.println("Enter your name:");
				String custname=scanner.nextLine();
				System.out.println("Enter checkin date(DD/MM/YYYY):");
				//LocalDate checkindate=LocalDate.now();
				//Instant checkindate=null;
				 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
//				  String date = "16/08/2016";
//
//				  //convert String to LocalDate
				  
				//SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
				String input = scanner.nextLine();
				LocalDate checkindate = LocalDate.parse(input, formatter);
//		        if(null != input && input.trim().length() > 0){
//		             try {
////						checkindate =format.parse(input).toInstant()
////							      .atZone(ZoneId.systemDefault())
////							      .toLocalDate();
//		            	 //checkindate = Instant.parse(input);
//		            	 
//					} catch (ParseException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//		        }
				System.out.println("Enter checkout date(DD/MM/YYYY):");
				//LocalDate checkoutdate=LocalDate.now();
				//Instant checkoutdate=null;
				String input1 = scanner.nextLine();
				LocalDate checkoutdate = LocalDate.parse(input, formatter);
//		        if(null != input1 && input1.trim().length() > 0){
//		             try {
//						checkoutdate =format.parse(input1).toInstant()
//							      .atZone(ZoneId.systemDefault())
//							      .toLocalDate();
		            	// checkoutdate = Instant.parse(input1);
//					} catch (ParseException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//		        }
		        System.out.println("Enter the total no. of persons:");
		        int noofpersons=scanner.nextInt();
		        System.out.println("Enter your contact no.:");
		        long contact=scanner.nextLong();
		        System.out.println("Want to add breakfast? Yes/No");
		        String answer=scanner.next();
		        boolean breakfast=false;
		        if(answer.equalsIgnoreCase("yes"))
		        	breakfast=true;
		        System.out.println("Enter the hotel id in which you want to stay:");
		        hotelid=scanner.nextInt();
		        booking=new Booking(custname, checkindate, checkoutdate, noofpersons, contact, breakfast);
		        bookingservice.bookHotel(booking, hotelid);
		        break;
			case 5:
				System.out.println("Enter contact:");
				long contact1=scanner.nextLong();
				try {
					System.out.println(bookingservice.bookingDetails(contact1));
				} catch (BookingIdNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 6:
				System.out.println("THANK YOU");
				continue;
			default:
				System.out.println("Wrong choice");
			}
			}while(choice!=6);
		}
		scanner.close();
	}
}
