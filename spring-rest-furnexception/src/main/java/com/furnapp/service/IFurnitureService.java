package com.furnapp.service;

import com.furnapp.exceptions.FurnitureNotFoundException;
import com.furnapp.model.*;

import java.util.List;

public interface IFurnitureService {
    public void addNewFurniture(Furniture furniture);
    public void updateFurniture(Furniture furniture);
    public void deleteByFurnitureId(int furnitureId);


    List<Furniture> getByCategory(String category) throws FurnitureNotFoundException;
    List<Furniture> getByBrandStartingWith(String brand) throws FurnitureNotFoundException;
    List<Furniture> getByMaterial(String material) throws FurnitureNotFoundException;
    List<Furniture> getByRoomType(String roomType) throws FurnitureNotFoundException;
    List<Furniture> getByStyle(String style) throws FurnitureNotFoundException;

    Furniture getById(int furnitureId) throws FurnitureNotFoundException;
    List<Furniture> getByStorageAvailable(boolean storage);

    List<Furniture> getByPriceRange(double minPrice,double maxPrice) throws FurnitureNotFoundException;
    List<Furniture> getByMaterialAndBrand(String material,String brand);
    List<Furniture> getByRoomAndCategory(String roomType,String category);
    Integer getTotal();

}
