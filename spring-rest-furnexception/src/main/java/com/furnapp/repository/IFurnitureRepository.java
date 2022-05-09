package com.furnapp.repository;

import com.furnapp.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Type;
import java.util.List;

@Repository
public interface IFurnitureRepository extends JpaRepository<Furniture,Integer> {
//    public void addNewFurniture(Furniture furniture);
//    public void updateFurniture(int furnitureId,double price);
//    public void deleteFurniture(int furnitureId);

    //derived queries
    List<Furniture> findByCategory(Category category);
    List<Furniture> findByBrandStartingWith(String brand);
    List<Furniture> findByMaterial(Material material);
    List<Furniture> findByRoomType(RoomType roomType);
    List<Furniture> findByStyle(Style style);
    List<Furniture> findByStorageAvailable(boolean storage);
    Furniture findById(int furnitureId);

    //custom query
    @Query("from Furniture f where f.price>?1 and f.price<?2")
    List<Furniture> findByPriceRange(double minPrice,double maxPrice);
    @Query("from Furniture f where f.material=?1 and f.brand=?2")
    List<Furniture> findByMaterialAndBrand(Material material,String brand);
    @Query("from Furniture f where f.roomType=?1 and f.category=?2")
    List<Furniture> findByRoomAndCategory(RoomType roomType,Category category);
    //native query
    @Query(value="select count(*) from furniture",nativeQuery=true)
    Integer findTotal();
    //named query
//    @Query(name="getCategoryCost")
//    Integer findCategoryCost(String category);
    
    
}
