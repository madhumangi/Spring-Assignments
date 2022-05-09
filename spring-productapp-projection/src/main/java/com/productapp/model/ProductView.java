package com.productapp.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class ProductView {
    @Column(name="productid")
    @Id
    private Integer productId;
    private double price;
    private String brand;
    private String name;
}
