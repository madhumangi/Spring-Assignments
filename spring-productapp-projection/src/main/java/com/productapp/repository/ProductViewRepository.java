package com.productapp.repository;

import com.productapp.model.ProductDetailsEx;
import com.productapp.model.ProductView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductViewRepository extends JpaRepository<ProductView,Integer> {
    //for view
//    List<ProductView> getByBrand(String brand);


    //open projection
    List<ProductDetailsEx> getByBrand(String brand);
}
