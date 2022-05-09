package com.productapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

//use only the properties that you want to preview
//should have only parameterized constructor
//should have only getter methods
//should have only toString method also
//the property names should  be same as the domain model
@AllArgsConstructor
@Getter
@ToString
public class ProductDTO {
    String name;
    double price;


}
