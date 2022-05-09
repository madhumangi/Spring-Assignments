package com.productapp.repository;

import com.productapp.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
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

//projections
    List<ProductDTO> findByBrand(String brand);
    @Query("select new com.productapp.model.CategoryDTO(p.name,p.brand) from Product p where p.category=?1 and p.price<?2")
    List<CategoryDTO> findByCategoryAndPriceLessThan(String category, double price);

    //give the product name and get the product details not complete product

//    @Query("select new com.productapp.model.ProductDetails from Product p where p.name=?1")
    ProductDetails findByName(String name);


    //stored procedures use @Procedure
    //use the same procedure name as method name
    @Procedure
    List<Product> SHOW_PRODUCTS();

    //give a custom method name and pass the procedure name as attribute
//    @Procedure("SHOW_PRODUCTS")
    @Procedure(value="SHOW_PRODUCTS")
    List<Product> getAllProducts();

    @Procedure(procedureName="SHOW_BY_BRAND")
    List<Product> readByBrand(String brand);

    @Procedure(procedureName = "SUM_OF_PRODUCTS")
    double getTotalCost(String brand);
}
