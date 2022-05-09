package com.productapp.model;




import javax.persistence.*;

@Entity
public class Product {
    @Column(length = 20)
    private String name;
    @Column(name = "productid")
    @Id
    @GeneratedValue(generator = "product_gen", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "product_gen", sequenceName = "product_sequence", initialValue = 100, allocationSize = 1)
    private Integer productId;
    @Column(length = 20)
    private String category;
    @Column(length = 20)
    private String brand;
    private double price;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "\n Product [productId=" + productId + ", name=" + name + ", category=" + category + ", brand=" + brand
                + ", price=" + price + "]";
    }

}
