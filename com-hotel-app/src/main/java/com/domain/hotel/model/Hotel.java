package com.domain.hotel.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Hotel {
    String hotelName;
    Integer hotelId;
    String city;
    float ratings;
    String grade;
    double pricePerDay;

}
