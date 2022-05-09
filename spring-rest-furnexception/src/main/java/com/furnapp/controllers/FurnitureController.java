package com.furnapp.controllers;

import com.furnapp.exceptions.FurnitureNotFoundException;
import com.furnapp.exceptions.FurnitureNotFoundException;
import com.furnapp.model.*;
import com.furnapp.service.IFurnitureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("furn-app")
public class FurnitureController {

    private IFurnitureService furnitureService;
    @Autowired
    public void setFurnitureService(IFurnitureService furnitureService) {
        this.furnitureService = furnitureService;
    }

    @PostMapping("/furnitures")
    ResponseEntity<Void> addNewFurniture(@RequestBody Furniture furniture){
    furnitureService.addNewFurniture(furniture);
    ResponseEntity<Void> responseEntity=ResponseEntity.status(HttpStatus.CREATED).build();
    return responseEntity;
    }
    @PutMapping("/furnitures")
    ResponseEntity<Void> updateFurniture(@RequestBody Furniture furniture){
        furnitureService.updateFurniture(furniture);
        ResponseEntity<Void> responseEntity=ResponseEntity.status(HttpStatus.ACCEPTED).build();
        return responseEntity;
        
    }
    @DeleteMapping("/furnitures/furnitureId/{furnitureId}")
    ResponseEntity<Void> deleteByFurnitureId(@PathVariable("furnitureId") int furnitureId){
        furnitureService.deleteByFurnitureId(furnitureId);
        HttpHeaders httpHeaders=new HttpHeaders();
        httpHeaders.add("desc","Deleting by Id "+furnitureId);
        return ResponseEntity.status(HttpStatus.OK).headers(httpHeaders).build();
    }

    @GetMapping("furnitures/category/{category}")
    ResponseEntity<List<Furniture>> showByCategory(@PathVariable("category") String category) throws FurnitureNotFoundException{
        System.out.println(category);
        List<Furniture> furnitures=furnitureService.getByCategory(category);
        HttpHeaders httpHeaders=new HttpHeaders();
        httpHeaders.add("desc","Get by category "+category);
        return ResponseEntity.status(HttpStatus.OK).headers(httpHeaders).body(furnitures);
    }
    @GetMapping("furnitures/brand/{brand}")
    ResponseEntity<List<Furniture>> showByBrandStartingWith(@PathVariable("brand") String brand) throws FurnitureNotFoundException{
        List<Furniture> furnitures=furnitureService.getByBrandStartingWith(brand);
        HttpHeaders httpHeaders=new HttpHeaders();
        httpHeaders.add("desc","Get by brand starting with "+brand);
        return ResponseEntity.status(HttpStatus.OK).headers(httpHeaders).body(furnitures);
    }
    @GetMapping("/furnitures/material/{material}")
    ResponseEntity<List<Furniture>> showByMaterial(@PathVariable("material") String material) throws FurnitureNotFoundException{
        List<Furniture> furnitures=furnitureService.getByMaterial(material);
        HttpHeaders httpHeaders=new HttpHeaders();
        httpHeaders.add("desc","Get by material "+material);
        return ResponseEntity.status(HttpStatus.OK).headers(httpHeaders).body(furnitures);
    }
    @GetMapping("/furnitures/roomType/{roomType}")
    ResponseEntity<List<Furniture>> showByRoomType(@PathVariable("roomType") String roomType) throws FurnitureNotFoundException{
        List<Furniture> furnitures=furnitureService.getByRoomType(roomType);
        HttpHeaders httpHeaders=new HttpHeaders();
        httpHeaders.add("desc","Get by roomtype "+roomType);
        return ResponseEntity.status(HttpStatus.OK).headers(httpHeaders).body(furnitures);
    }
    @GetMapping("/furnitures/style/{style}")
    ResponseEntity<List<Furniture>> showByStyle(@PathVariable("style") String style) throws FurnitureNotFoundException{
        List<Furniture> furnitures=furnitureService.getByStyle(style);
        HttpHeaders httpHeaders=new HttpHeaders();
        httpHeaders.add("desc","Get by style "+style);
        return ResponseEntity.status(HttpStatus.OK).headers(httpHeaders).body(furnitures);
    }
    @GetMapping("/furnitures/furnitureId/{furnitureId}")
    ResponseEntity<Furniture> showById(@PathVariable("furnitureId") int furnitureId) throws FurnitureNotFoundException{
        Furniture furniture=furnitureService.getById(furnitureId);
        HttpHeaders httpHeaders=new HttpHeaders();
        httpHeaders.add("desc","Get by furnitureId "+furnitureId);
        return ResponseEntity.status(HttpStatus.OK).headers(httpHeaders).body(furniture);
    }
    @GetMapping("/furnitures/storage/{storage}")
    ResponseEntity<List<Furniture>> showByStorageAvailable(@PathVariable("storage") boolean storage){
        List<Furniture> furnitures=furnitureService.getByStorageAvailable(storage);
        HttpHeaders httpHeaders=new HttpHeaders();
        httpHeaders.add("desc","Get by storage available "+storage);
        return ResponseEntity.status(HttpStatus.OK).headers(httpHeaders).body(furnitures);
    }
    @GetMapping("furnitures/minPrice/{minPrice}/maxPrice/{maxPrice}")
    ResponseEntity<List<Furniture>> showByPriceRange(@PathVariable("minPrice") double minPrice,@PathVariable("maxPrice") double maxPrice) throws FurnitureNotFoundException {
        List<Furniture> furnitures=furnitureService.getByPriceRange(minPrice, maxPrice);
        HttpHeaders httpHeaders=new HttpHeaders();
        httpHeaders.add("desc","Get by price range between"+minPrice+" and"+maxPrice);
        return ResponseEntity.status(HttpStatus.OK).headers(httpHeaders).body(furnitures);
    }
    @GetMapping("furnitures/material/{material}/brand/{brand}")
    ResponseEntity<List<Furniture>> showByMaterialAndBrand(@PathVariable("material") String material,@PathVariable("brand") String brand){
        List<Furniture> furnitures=furnitureService.getByMaterialAndBrand(material, brand);
        HttpHeaders httpHeaders=new HttpHeaders();
        httpHeaders.add("desc","Get by material"+material+" and brand "+brand);
        return ResponseEntity.status(HttpStatus.OK).headers(httpHeaders).body(furnitures);
    }
    @GetMapping("/furnitures/roomType/{roomType}/category/{category}")
    ResponseEntity<List<Furniture>> showByRoomAndCategory(@PathVariable("roomType") String roomType,@PathVariable("category") String category){
        List<Furniture> furnitures=furnitureService.getByRoomAndCategory(roomType, category);
        HttpHeaders httpHeaders=new HttpHeaders();
        httpHeaders.add("desc","Get by room type "+roomType+" and category "+category);
        return ResponseEntity.status(HttpStatus.OK).headers(httpHeaders).body(furnitures);
    }
    @GetMapping("/furnitures/total")
    ResponseEntity<Integer> showTotal(){
        HttpHeaders httpHeaders=new HttpHeaders();
        httpHeaders.add("desc","Get total ");
        return ResponseEntity.status(HttpStatus.OK).headers(httpHeaders).body(furnitureService.getTotal());
    }
}
