package com.furnapp.service;

import com.furnapp.exceptions.FurnitureNotFoundException;
import com.furnapp.model.*;
import com.furnapp.repository.IFurnitureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FurnitureServiceImpl implements IFurnitureService{
    @Autowired
    IFurnitureRepository furnitureRepository;
    @Override
    public void addNewFurniture(Furniture furniture) {
        furnitureRepository.save(furniture);
    }

    @Override
    public void updateFurniture(Furniture furniture) {
    
        furnitureRepository.save(furniture);
    }

    @Override
    public void deleteByFurnitureId(int furnitureId) {
        furnitureRepository.deleteById(furnitureId);
    }

    @Override
    public List<Furniture> getByCategory(String category) throws FurnitureNotFoundException {
        System.out.println(category);
        List<Furniture> furnitures=furnitureRepository.findByCategory(Category.valueOf(category));
        if(furnitures.isEmpty())
            throw new FurnitureNotFoundException("Category not found");
        else
            return furnitures;
    }

    @Override
    public List<Furniture> getByBrandStartingWith(String brand) throws FurnitureNotFoundException {
        List<Furniture> furnitures=furnitureRepository.findByBrandStartingWith(brand);
        if(furnitures.isEmpty())
            throw new FurnitureNotFoundException("Brand not found");
        else
            return furnitures;
    }

    @Override
    public List<Furniture> getByMaterial(String material) throws FurnitureNotFoundException {
        List<Furniture> furnitures=furnitureRepository.findByMaterial(Material.valueOf(material));
        if(furnitures.isEmpty())
            throw new FurnitureNotFoundException("material not found");
        else
            return furnitures;
    }

    @Override
    public List<Furniture> getByRoomType(String roomType) throws FurnitureNotFoundException {
        List<Furniture> furnitures=furnitureRepository.findByRoomType(RoomType.valueOf(roomType));
        if(furnitures.isEmpty())
            throw new FurnitureNotFoundException("room type not found");
        else
            return furnitures;
    }


    @Override
    public List<Furniture> getByStyle(String style) throws FurnitureNotFoundException {
        List<Furniture> furnitures=furnitureRepository.findByStyle(Style.valueOf(style));
        if(furnitures.isEmpty())
            throw new FurnitureNotFoundException("style not found");
        else
            return furnitures;
    }


    @Override
    public List<Furniture> getByStorageAvailable(boolean storage) {
        return furnitureRepository.findByStorageAvailable(storage);
    }

    @Override
    public List<Furniture> getByPriceRange(double minPrice, double maxPrice) {
        return furnitureRepository.findByPriceRange(minPrice, maxPrice);

    }

    @Override
    public List<Furniture> getByMaterialAndBrand(String material, String brand) {
        return furnitureRepository.findByMaterialAndBrand(Material.valueOf(material), brand);

    }

    @Override
    public List<Furniture> getByRoomAndCategory(String roomType, String category){
        return furnitureRepository.findByRoomAndCategory(RoomType.valueOf(roomType),Category.valueOf(category));

    }

    @Override
    public Integer getTotal() {
        return furnitureRepository.findTotal();
    }

    @Override
    public Furniture getById(int furnitureId) throws FurnitureNotFoundException {
        Furniture furniture=furnitureRepository.findById(furnitureId);
        if(furniture!=null)
            return furniture;
        else
            throw new FurnitureNotFoundException("Furniture not found");

    }
}
