package com.productapp.model;

import lombok.*;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class ProductBrandView {

    @Column(name="productid")
    @Id
    private Integer productId;
    private double price;
    private String brand;
    private String name;


}
