package com.productapp.service;

import com.productapp.exceptions.ProductNotFoundException;
import com.productapp.model.*;
import com.productapp.repository.IProductRepository;
import com.productapp.repository.ProductBrandViewRepository;
import com.productapp.repository.ProductViewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductServiceImpl implements IProductService{
    @Autowired
    private IProductRepository productRepository;


    private ProductViewRepository productViewRepository;
    @Autowired
    public void setProductViewRepository(ProductViewRepository productViewRepository) {
        this.productViewRepository = productViewRepository;
    }

    private ProductBrandViewRepository productBrandView;
    @Autowired
    public void setProductBrandView(ProductBrandViewRepository productBrandView) {
        this.productBrandView = productBrandView;
    }




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
    public List<ProductDTO> getByBrand(String brand) {
        return productRepository.findByBrand(brand);
    }

    @Override
    public List<CategoryDTO> getByCategoryPriceLessThan(String category, double price) {
        return productRepository.findByCategoryAndPriceLessThan(category,price);
    }

    @Override
    public ProductDetails getByName(String name) {
        return productRepository.findByName(name);
    }
//from view
    @Override
    public List<ProductView> getAllProducts() {
        return productViewRepository.findAll();
    }

    @Override
    public List<ProductBrandView> getByBrands(String brand) {
        return productBrandView.findByBrand(brand);
    }

    @Override
    public List<ProductDetailsEx> findByBrand(String brand) {
        return productViewRepository.getByBrand(brand);
    }

    @Override
    @Transactional
    public List<Product> showAllProducts() {
        return productRepository.SHOW_PRODUCTS();
    }

    @Override
    @Transactional
    public List<Product> findAllProducts() {
        return productRepository.getAllProducts();
    }

    @Override
    @Transactional
    public List<Product> showByBrand(String brand) {
        return productRepository.readByBrand(brand);
    }

    @Override
    public double findTotalCost(String brand) {
        return productRepository.getTotalCost(brand);
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
