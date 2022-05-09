package com.productapp.repository;

import com.productapp.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductRepository extends JpaRepository<Product,Integer> {
    @Query("from Product p where p.category=?1 or p.brand=?1")
    List<Product> findByChoice(String choice);
    List<Product> findByCategory(String category);
    List<Product> findByPriceLessThan(double price);
    List<Product> findByBrandAndPriceLessThan(String brand,double price);
    List<Product> findByBrandStartingWith(String brand);

}
