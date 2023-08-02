package com.dabbawala.controller;

import com.dabbawala.dto.RestaurantDto;
import com.dabbawala.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;
   //===========================================================
   //Register Restaurant
    @PostMapping("/restaurant")
   public ResponseEntity<String> registerRestaurant(@RequestBody RestaurantDto restaurantDto){
       return ResponseEntity.status(HttpStatus.CREATED).body(restaurantService.registerRestaurant(restaurantDto));
   }
    //===========================================================
    //get single Restaurant
    @GetMapping("/restaurant/single")
    public ResponseEntity<RestaurantDto> getSingleRestaurant(@RequestParam int restaurantId){
        return  ResponseEntity.status(HttpStatus.OK).body(restaurantService.getSingleRestaurant(restaurantId));
    }
    //===========================================================
    //Get All Restaurant
    @GetMapping("/restaurant")
    public ResponseEntity<List<RestaurantDto>> getAllRestaurant(){
        return  ResponseEntity.ok(restaurantService.getAllRestaurant());
    }
    //===========================================================
    //To Update Restaurant
    @PutMapping("/restaurant")
    public ResponseEntity<String> updateRestaurant(@RequestBody RestaurantDto restaurantDto){
        return ResponseEntity.status(HttpStatus.OK).body(restaurantService.updateRestaurant(restaurantDto));
    }
    //===========================================================
    //To Delete Restaurant
    @DeleteMapping("/restaurant/{restaurantId}")
    public ResponseEntity<String> deleteRestaurant(@PathVariable int restaurantId){
        return ResponseEntity.status(HttpStatus.OK).body(restaurantService.deleteRestaurant(restaurantId));
    }
    //===========================================================
}
