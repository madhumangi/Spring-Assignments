package com.productapp.service;

import com.productapp.exceptions.ProductNotFoundException;
import com.productapp.model.Product;

import java.util.List;

public interface IProductService {
    void addProduct(Product product);
    void updateProduct(Product product);
    void deleteProduct(int productId);

    Product getById(int productId) throws ProductNotFoundException;

    List<Product> getAll();
    List<Product> getByBrandAndPriceLessThan(String brand,double price) throws ProductNotFoundException;
    List<Product> getByCategory(String category) throws ProductNotFoundException;
    List<Product> getByPriceLessThan(double price) throws ProductNotFoundException;
    List<Product> getByBrandStartingWith(String brand) throws ProductNotFoundException;
    List<Product> getByChoice(String choice);
}
