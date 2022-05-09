package com.productapp.controllers;

import com.productapp.exceptions.ProductNotFoundException;
import com.productapp.model.*;
import com.productapp.repository.ProductBrandViewRepository;
import com.productapp.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    @GetMapping("/products/brand-starting{brand}")
    ResponseEntity<List<Product>> getByBrandStartingWith(@PathVariable("brand") String brand){
        List<Product> products=productService.getByBrandStartingWith(brand);
        ResponseEntity<List<Product>> productResponse=ResponseEntity.ok().body(products);
        return productResponse;
    }
    @GetMapping("/products/category-starting/{category}")
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

    @GetMapping("/products/brand/{brand}")
    ResponseEntity<List<ProductDTO>> getByBrand(@PathVariable("brand")String brand) throws ProductNotFoundException{
        List<ProductDTO> products = productService.getByBrand(brand);
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc","Get by brand"+brand);
        return ResponseEntity.ok().headers(headers).body(products);

    }

    @GetMapping("/products/category/{category}/price/{price}")
    ResponseEntity<List<CategoryDTO>> getByCategoryPriceLessThan(@PathVariable("category")String category,@PathVariable("price")double price) throws ProductNotFoundException{
        List<CategoryDTO> products = productService.getByCategoryPriceLessThan(category, price);
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc","Get by category"+category+" price less than "+price);
        return ResponseEntity.ok().headers(headers).body(products);

    }

    @GetMapping("/products/name/{name}")
    ResponseEntity<ProductDetails> getByName(@PathVariable("name")String name) throws ProductNotFoundException{
        ProductDetails products = productService.getByName(name);
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc","Get by name"+name);
        return ResponseEntity.ok().headers(headers).body(products);

    }

    //view
    @GetMapping("/products/all")
    ResponseEntity<List<ProductView>> getAllProducts(){
        List<ProductView> products=productService.getAllProducts();
        HttpHeaders headers=new HttpHeaders();
        headers.add("desc","getting all products");
        headers.add("info","Get all methods call");
        ResponseEntity<List<ProductView>> productResponse=
                new ResponseEntity<List<ProductView>>(products,headers, HttpStatus.OK);
        return productResponse;
    }

    @GetMapping("/products/brands/{brand}")
    ResponseEntity<List<ProductBrandView>> getByBrands(@PathVariable("brand")String brand) throws ProductNotFoundException{
        List<ProductBrandView> products = productService.getByBrands(brand);
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc","Get by brand"+brand);
        return ResponseEntity.ok().headers(headers).body(products);
    }

    @GetMapping("/products/brandex/{brand}")
    ResponseEntity<List<String>> getByBrandEx(@PathVariable("brand")String brand) throws ProductNotFoundException{
        List<ProductDetailsEx> products = productService.findByBrand(brand);
        List<String> pdata=new ArrayList<>();
        for(ProductDetailsEx product:products){
            String data=product.getProduct();
            pdata.add(data);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc","Get by brand"+brand);
        return ResponseEntity.ok().headers(headers).body(pdata);
    }

    @GetMapping("/products/show")
    ResponseEntity<List<Product>> showAllProducts(){
        List<Product> products=productService.showAllProducts();
        HttpHeaders headers=new HttpHeaders();
        headers.add("desc","getting all products");
        headers.add("info","Get all methods call");
        ResponseEntity<List<Product>> productResponse=
                new ResponseEntity<List<Product>>(products,headers, HttpStatus.OK);
        return productResponse;
    }

    @GetMapping("/products/getall")
    ResponseEntity<List<Product>> getAllProductsAvailable(){
        List<Product> products=productService.findAllProducts();
        HttpHeaders headers=new HttpHeaders();
        headers.add("desc","getting all products");
        headers.add("info","Get all methods call");
        ResponseEntity<List<Product>> productResponse=
                new ResponseEntity<List<Product>>(products,headers, HttpStatus.OK);
        return productResponse;
    }

    @GetMapping("/products/procedurebrand/{brand}")
    ResponseEntity<List<Product>> showByBrand(@PathVariable("brand")String brand) throws ProductNotFoundException{
        List<Product> products = productService.showByBrand(brand);
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc","Get by brand"+brand);
        return ResponseEntity.ok().headers(headers).body(products);
    }
//    @GetMapping("/products/total/brand")
//    ResponseEntity<double> getTotal(@PathVariable("brand")String brand){
//        double cost=productService.findTotalCost(brand);
//        HttpHeaders headers=new HttpHeaders();
//        headers.add("desc","getting all products");
//        headers.add("info","Get all methods call");
//        ResponseEntity<List<Product>> productResponse=
//                new ResponseEntity<List<Product>>(products,headers, HttpStatus.OK);
//        return productResponse;
//    }


}
