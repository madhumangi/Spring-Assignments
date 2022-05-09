package com.productapp.controllers;

import com.productapp.exceptions.ProductNotFoundException;
import com.productapp.model.Product;
import com.productapp.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("product-api")
public class ProductController {

    private IProductService productService;
    @Autowired
    public void setProductService(IProductService productService){
        this.productService=productService;
    }


    @PostMapping("/products")
    ResponseEntity<Void> addProduct(@RequestBody Product product){
        productService.addProduct(product);
        ResponseEntity<Void> responseEntity=
        ResponseEntity.status(HttpStatus.CREATED).build();
        return responseEntity;
    }
    @PutMapping("/products")
    ResponseEntity<Void> updateProduct(@RequestBody Product product){
        productService.updateProduct(product);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
    @DeleteMapping("/products/productId/{productId}")
    ResponseEntity<Void> deleteProduct(@PathVariable("productId") int productId){
        productService.deleteProduct(productId);
        HttpHeaders httpHeaders=new HttpHeaders();
        httpHeaders.add("desc","deleting product by id");
        return ResponseEntity.status(HttpStatus.OK).headers(httpHeaders).build();

    }
    @GetMapping("products/productId/{productId}")
    ResponseEntity<Product> getById(@PathVariable("productId") int productId){
        Product product=productService.getById(productId);
        HttpHeaders httpHeaders=new HttpHeaders();
        httpHeaders.add("desc","get one product by id");
        return ResponseEntity.status(HttpStatus.OK).headers(httpHeaders).body(product);
    }




    @GetMapping("/products")
    ResponseEntity<List<Product>> getAll(){
        List<Product> products=productService.getAll();
        HttpHeaders headers=new HttpHeaders();
        headers.add("desc","getting all products");
        headers.add("info","Get all methods call");
        ResponseEntity<List<Product>> productResponse=
                new ResponseEntity<>(products,headers, HttpStatus.OK);
           return productResponse;
    }
    @GetMapping("/products/brand/{brand}")
    ResponseEntity<List<Product>> getByBrandStartingWith(@PathVariable("brand") String brand){
        List<Product> products=productService.getByBrandStartingWith(brand);
        ResponseEntity<List<Product>> productResponse=ResponseEntity.ok().body(products);
        return productResponse;
    }
    @GetMapping("/products/category/{category}")
    ResponseEntity<List<Product>> getByCategory(@PathVariable("category") String category){
        List<Product> products=productService.getByCategory(category);
        HttpHeaders headers=new HttpHeaders();
        headers.add("desc","Get by category "+category);
        return ResponseEntity.ok().headers(headers).body(products);

    }
    @GetMapping("/products/price/{price}")
    ResponseEntity<List<Product>> getByPriceLessThan(@PathVariable("price") double price){
        List<Product> products=productService.getByPriceLessThan(price);
        HttpHeaders httpHeaders=new HttpHeaders();
        httpHeaders.add("desc","Get By lesser price"+price);
        return ResponseEntity.status(HttpStatus.OK).headers(httpHeaders).body(products);
    }
    @GetMapping("/products/brand/{brand}/price/{price}")
    ResponseEntity<List<Product>> getByBrandAndPrice(@PathVariable("brand") String brand,@PathVariable("price") double price){
    List<Product> products=productService.getByBrandAndPriceLessThan(brand, price);
    HttpHeaders httpHeaders=new HttpHeaders();
    httpHeaders.add("desc","Get by brand "+brand+" lesser price "+price);
    return ResponseEntity.status(HttpStatus.OK).headers(httpHeaders).body(products);
    }
    @GetMapping("/products/choice/{choice}")
    ResponseEntity<List<Product>> getByChoice(@PathVariable("choice") String choice){
        List<Product> products=productService.getByChoice(choice);
        HttpHeaders httpHeaders=new HttpHeaders();
        httpHeaders.add("desc","Get by choice "+choice);
        return ResponseEntity.status(HttpStatus.OK).headers(httpHeaders).body(products);
    }
}
