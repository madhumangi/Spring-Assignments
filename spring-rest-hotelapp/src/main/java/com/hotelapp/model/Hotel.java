package com.hotelapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Hotel {

    private String hotelName;
    @Id
    @GeneratedValue(generator="hotel_gen",strategy= GenerationType.AUTO)
    @SequenceGenerator(name="hotel_gen",sequenceName="hotel_sequence",initialValue=101,allocationSize=1)
    private Integer hotelId;
    @Column(length = 20)
    private String city;
    private double ratings;
    @Column(length = 20)
    private String type;          //3star,4star,5 star
    private double price;
    @Column(length = 20)
    private String propertyType;  //- B&B resort/business/lodge
    @Column(length = 20)
    private String distance;
    //private String roomType;
    private boolean restaurantIncluded;
    private LocalDate checkIn;
    private LocalDate checkOut;
    private Integer totalNoOfRooms;


    @Override
    public String toString() {
        return "Hotel{" +
                "hotelName='" + hotelName + '\'' +
                ", city='" + city + '\'' +
                ", ratings=" + ratings +
                ", type='" + type + '\'' +
                ", pricePerDay=" + price +
                ", propertyType='" + propertyType + '\'' +
                ", distance='" + distance + '\'' +
                ", restaurantIncluded=" + restaurantIncluded +
//                ", checkIn=" + checkIn +
//                ", checkOut=" + checkOut +
                ", totalNoOfRooms=" + totalNoOfRooms +
                '}';
    }
}
