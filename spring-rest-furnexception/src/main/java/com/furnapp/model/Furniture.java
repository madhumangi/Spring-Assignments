package com.furnapp.model;

import lombok.*;

import javax.persistence.*;

//import com.furnapp.model.Style;
//import com.furnapp.model.Category;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Furniture {
    @Column(length=30)
    private String name;//4 seater dining table king size bed
    @Id
    @GeneratedValue(generator="furniture_gen",strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "furniture_gen",sequenceName = "furniture_sequence",initialValue = 1,allocationSize = 1)
    private Integer furnitureId;
    @Column(length=30)
    private String brand;
    @Column(length=30)
    @Enumerated(EnumType.STRING)
    private RoomType roomType;//beds chairs table
    @Enumerated(EnumType.STRING)
    private Category category;//living bedroom study hall
    @Enumerated(EnumType.STRING)
    private Style style;//modern aesthetic retro
    private double price;
    private boolean storageAvailable;
    @Column(length=30)
    @Enumerated(EnumType.STRING)
    private Material material;//wood iron plastic2

    public Furniture(String name, String brand, RoomType roomType, Category category, Style style, double price, boolean storageAvailable, Material material) {
        this.name = name;
        this.brand = brand;
        this.roomType = roomType;
        this.category = category;
        this.style = style;
        this.price = price;
        this.storageAvailable = storageAvailable;
        this.material = material;
    }

}
