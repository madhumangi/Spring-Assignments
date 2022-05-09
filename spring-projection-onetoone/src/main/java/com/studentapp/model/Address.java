package com.studentapp.model;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Address {

    @Id
    @GeneratedValue(generator = "address_gen",strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "address_gen",sequenceName = "address_sequence",initialValue = 1,allocationSize = 1)
    private Integer addId;
    @Column(length=20)
    private  String city;
    @Column(length=20)
    private String state;

    public Address(String city, String state) {
        this.city = city;
        this.state = state;
    }
}
