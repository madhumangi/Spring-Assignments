package com.productapp.service;

import com.productapp.exceptions.ProductNotFoundException;
import com.productapp.model.Product;
import com.productapp.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements IProductService{
    @Autowired
    private IProductRepository productRepository;


    @Override
    public void addProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public void updateProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public void deleteProduct(int productId) {
        productRepository.deleteById(productId);
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();

    }

    @Override
    public Product getById(int productId) throws ProductNotFoundException {
        return productRepository.findById(productId).get();//.orElseThrow(()->new ProductNotFoundException("Inavlid ID"));
    }


    @Override
    public List<Product> getByCategory(String category) throws ProductNotFoundException {
        return productRepository.findByCategory(category);
    }



    @Override
    public List<Product> getByBrandStartingWith(String brand) throws ProductNotFoundException {
        return productRepository.findByBrandStartingWith(brand);
    }

    @Override
    public List<Product> getByChoice(String choice) {
        return productRepository.findByChoice(choice);
    }

    @Override
    public List<Product> getByBrandAndPriceLessThan(String brand,double price) throws ProductNotFoundException {
        return productRepository.findByBrandAndPriceLessThan(brand,price);
    }


    @Override
    public List<Product> getByPriceLessThan(double price) throws ProductNotFoundException {
        return productRepository.findByPriceLessThan(price);
    }
}
