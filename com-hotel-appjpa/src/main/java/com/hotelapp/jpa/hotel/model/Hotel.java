package com.hotelapp.jpa.hotel.model;

import lombok.*;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Hotel {
    @Column(length=20)
    private String hotelName;
    @Id
            @GeneratedValue(generator = "hotel_gen",strategy = GenerationType.AUTO)
            @SequenceGenerator(name = "hotel_gen",sequenceName = "hotel_sequence",initialValue = 1,allocationSize = 1)
    private Integer hotelId;
    @Column(length=20)
    private String city;
    private float ratings;
    @Enumerated(EnumType.STRING)
    private Grade grade;
    private double pricePerDay;

    public Hotel(String hotelName, String city, float ratings, Grade grade, double pricePerDay) {
        this.hotelName = hotelName;
        this.city = city;
        this.ratings = ratings;
        this.grade = grade;
        this.pricePerDay = pricePerDay;
    }
}
