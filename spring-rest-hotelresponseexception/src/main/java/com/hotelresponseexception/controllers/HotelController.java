package com.hotelresponseexception.controllers;

import com.hotelresponseexception.model.Hotel;
import com.hotelresponseexception.service.IHotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Void> addHotel(@RequestBody Hotel hotel){
        hotelService.addHotel(hotel);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @PutMapping("/hotels")
    public ResponseEntity<Void> updateHotel(@RequestBody Hotel hotel){
        hotelService.updateHotel(hotel);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @DeleteMapping("/hotels/id/{hotelId}")
    public ResponseEntity<Void> deleteHotel(@PathVariable("hotelId")int hotelId){
        hotelService.deleteHotel(hotelId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/hotels/id/{hotelId}")
    public ResponseEntity<Hotel> showHotelById(@PathVariable("hotelId")int hotelId){
        Hotel hotel=hotelService.getHotelById(hotelId);
        HttpHeaders httpheaders=new HttpHeaders();
        httpheaders.add("desc","Get by Id"+hotelId);
        return ResponseEntity.status(HttpStatus.OK).headers(httpheaders).body(hotel);
    }

    @GetMapping("/hotels")
    public ResponseEntity<List<Hotel>> showAllHotels(){
        List<Hotel> hotels=hotelService.getAllHotels();
        HttpHeaders httpheaders=new HttpHeaders();
        httpheaders.add("desc","Get all");
        return ResponseEntity.status(HttpStatus.OK).headers(httpheaders).body(hotels);
    }

    @GetMapping("/hotels/ratings/{ratings}/type/{type}")
    public ResponseEntity<List<Hotel>> showByRatingsAndType(@PathVariable("ratings")double ratings,@PathVariable("type")String type){
       List<Hotel> hotels=hotelService.getHotelByRatingsAndType(ratings, type);
        HttpHeaders httpheaders=new HttpHeaders();
        httpheaders.add("desc","Get by ratings "+ratings+" and type "+type);
        return ResponseEntity.status(HttpStatus.OK).headers(httpheaders).body(hotels);
    }

    @GetMapping("/hotels/city/{city}/distance/{distance}")
    public ResponseEntity<List<Hotel>> showByCityAndDistance(@PathVariable("city")String city,@PathVariable("distance")String distance){
        List<Hotel> hotels=hotelService.getHotelByCityAndDistance(city,distance);
        HttpHeaders httpheaders=new HttpHeaders();
        httpheaders.add("desc","Get by city "+city+" and distance "+distance);
        return ResponseEntity.status(HttpStatus.OK).headers(httpheaders).body(hotels);
    }

    @GetMapping("/hotels/price/{price}")
    public ResponseEntity<List<Hotel>> showByLessPrice(@PathVariable("price") double price){
        List<Hotel> hotels=hotelService.getByPriceLessThan(price);
        HttpHeaders httpheaders=new HttpHeaders();
        httpheaders.add("desc","Get by price less than"+price);
        return ResponseEntity.status(HttpStatus.OK).headers(httpheaders).body(hotels);
    }

    @GetMapping("/hotels/restaurantincluded/{restaurantincluded}")
    public ResponseEntity<List<Hotel>> showByRestaurantIncluded(@PathVariable("restaurantincluded")boolean restaurantIncluded){
        List<Hotel> hotels=hotelService.getByRestaurantIncluded(restaurantIncluded);
        HttpHeaders httpheaders=new HttpHeaders();
        httpheaders.add("desc","Get by restaurant included "+restaurantIncluded);
        return ResponseEntity.status(HttpStatus.OK).headers(httpheaders).body(hotels);
    }

    @GetMapping("/hotels/propertytype/{propertytype}/totalnoofrooms/{totalnoofrooms}")
    public ResponseEntity<List<Hotel>> showByPropertyTypeAndTotalNoOfRooms(@PathVariable("propertytype")String propertyType,@PathVariable("totalnoofrooms")int totalNoOfRooms){
        List<Hotel> hotels=hotelService.getByPropertyTypeAndTotalNoOfRooms(propertyType, totalNoOfRooms);
        HttpHeaders httpheaders=new HttpHeaders();
        httpheaders.add("desc","Get by property type "+propertyType+" and total no of rooms "+totalNoOfRooms);
        return ResponseEntity.status(HttpStatus.OK).headers(httpheaders).body(hotels);
    }

    @GetMapping("/hotels/checkindate/{checkindate}")
    public ResponseEntity<List<Hotel>> showByCheckinDateLessThan(@PathVariable("checkindate")String checkinDate){
        List<Hotel> hotels=hotelService.getByCheckInDateLessThan(LocalDate.parse(checkinDate));
        HttpHeaders httpheaders=new HttpHeaders();
        httpheaders.add("desc","Get by checkin date "+checkinDate);
        return ResponseEntity.status(HttpStatus.OK).headers(httpheaders).body(hotels);
    }
    @GetMapping("/hotels/checkoutdate/{checkoutdate}")
    public ResponseEntity<List<Hotel>> showByCheckoutDateLessThan(@PathVariable("checkoutdate")LocalDate checkoutDate){
        List<Hotel> hotels=hotelService.getByCheckOutDateLessThan(checkoutDate);
        HttpHeaders httpheaders=new HttpHeaders();
        httpheaders.add("desc","Get by checkout date "+checkoutDate);
        return ResponseEntity.status(HttpStatus.OK).headers(httpheaders).body(hotels);
    }
}
