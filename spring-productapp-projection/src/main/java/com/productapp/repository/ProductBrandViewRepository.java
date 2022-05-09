package com.productapp.repository;

import com.productapp.model.ProductBrandView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductBrandViewRepository extends JpaRepository<ProductBrandView,Integer> {

    List<ProductBrandView> findByBrand(String brand);
}
