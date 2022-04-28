package com.hotelresponseexception.controllers;

import com.hotelresponseexception.model.Hotel;
import com.hotelresponseexception.service.IHotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("hotel-api")
public class HotelController {

    private IHotelService hotelService;
    @Autowired
    public void setHotelService(IHotelService hotelService) {
        this.hotelService = hotelService;
    }

    @PostMapping("/hotels")
    public void addHotel(@RequestBody Hotel hotel){
        hotelService.addHotel(hotel);
    }
    @PutMapping("/hotels")
    public void updateHotel(@RequestBody Hotel hotel){
        hotelService.updateHotel(hotel);
    }

    @DeleteMapping("/hotels/id/{hotelId}")
    public void deleteHotel(@PathVariable("hotelId")int hotelId){
        hotelService.deleteHotel(hotelId);
    }

    @GetMapping("/hotels/id/{hotelId}")
    public Hotel showHotelById(@PathVariable("hotelId")int hotelId){
        return hotelService.getHotelById(hotelId);
    }

    @GetMapping("/hotels")
    public List<Hotel> showAllHotels(){
        return hotelService.getAllHotels();
    }

    @GetMapping("/hotels/ratings/{ratings}/type/{type}")
    public List<Hotel> showByRatingsAndType(@PathVariable("ratings")double ratings,@PathVariable("type")String type){
        return hotelService.getHotelByRatingsAndType(ratings, type);
    }

    @GetMapping("/hotels/city/{city}/distance/{distance}")
    public List<Hotel> showByCityAndDistance(@PathVariable("city")String city,@PathVariable("distance")String distance){
        return hotelService.getHotelByCityAndDistance(city,distance);
    }

    @GetMapping("/hotels/price/{price}")
    public List<Hotel> showByLessPrice(@PathVariable("price") double price){
        return hotelService.getByPriceLessThan(price);
    }

    @GetMapping("/hotels/restaurantincluded/{restaurantincluded}")
    public List<Hotel> showByRestaurantIncluded(@PathVariable("restaurantincluded")boolean restaurantIncluded){
        return hotelService.getByRestaurantIncluded(restaurantIncluded);
    }

    @GetMapping("/hotels/propertytype/{propertytype}/totalnoofrooms/{totalnoofrooms}")
    public List<Hotel> showByPropertyTypeAndTotalNoOfRooms(@PathVariable("propertytype")String propertyType,@PathVariable("totalnoofrooms")int totalNoOfRooms){
        return hotelService.getByPropertyTypeAndTotalNoOfRooms(propertyType, totalNoOfRooms);
    }

    @GetMapping("/hotels/checkindate/{checkindate}")
    public List<Hotel> showByCheckinDateLessThan(@PathVariable("checkindate")String checkinDate){
        return hotelService.getByCheckInDateLessThan(LocalDate.parse(checkinDate));
    }
    @GetMapping("/hotels/checkoutdate/{checkoutdate}")
    public List<Hotel> showByCheckoutDateLessThan(@PathVariable("checkoutdate")LocalDate checkoutDate){
        return hotelService.getByCheckOutDateLessThan(checkoutDate);
    }
}
