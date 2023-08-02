package com.dabbawala.controller;

import com.dabbawala.dto.RestaurantDto;
import com.dabbawala.dto.RestaurantServiceDto;
import com.dabbawala.service.RestaurantServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RestaurantServiceController {
    @Autowired
    private RestaurantServiceService restaurantServiceService;
    //==============================================================================
    //To Register Restaurant Service
    @PostMapping("/restaurantService")
    public ResponseEntity<String> registerRestaurantService(@RequestBody RestaurantServiceDto restaurantServiceDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(restaurantServiceService.registerRestaurantService(restaurantServiceDto));
    }
    //==============================================================================
    //To Delete Restaurant Service
    @DeleteMapping("/restaurantService/{serviceId}")
    public ResponseEntity<String> deleteRestaurantService(@PathVariable int serviceId){
        return  ResponseEntity.status(HttpStatus.OK).body(restaurantServiceService.deleteRestaurantService(serviceId));
    }
    //==============================================================================
    //To Get All Restaurants Based On Service to a Particular Location
//    @GetMapping("/restaurantService/location/{location}")
//    public ResponseEntity<StringBuilder> getAllRestaurantsBasedOnParticularLocation(@PathVariable String location){
//        return ResponseEntity.status(HttpStatus.OK).body(restaurantServiceService.getAllRestaurantsBasedOnParticularLocation(location));
//    }
    //==============================================================================
    //To Get All Restaurants Based On Service to a Particular Location
    @GetMapping("/restaurantService/location/{location}")
    public ResponseEntity<List<RestaurantDto>> getAllRestaurantsBasedOnParticularLocation(@PathVariable String location){
        List<RestaurantDto> allRestaurantsBasedOnParticularLocation = restaurantServiceService.getAllRestaurantsBasedOnParticularLocation(location);
        if(!allRestaurantsBasedOnParticularLocation.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(allRestaurantsBasedOnParticularLocation);
        }else{
            return new  ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    //==============================================================================
}
