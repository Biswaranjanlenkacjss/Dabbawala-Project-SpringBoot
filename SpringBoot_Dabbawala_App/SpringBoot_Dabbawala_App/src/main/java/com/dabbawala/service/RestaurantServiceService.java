package com.dabbawala.service;

import com.dabbawala.dto.RestaurantDto;
import com.dabbawala.dto.RestaurantServiceDto;

import java.util.List;

public interface RestaurantServiceService {
    //======================================================
    //To Register Restaurant Service
    String registerRestaurantService(RestaurantServiceDto restaurantServiceDto);
    //======================================================
    //To Delete Restaurant Service
    String deleteRestaurantService(int serviceId);
    //=======================================================
//    //To Retrieve Restaurants based on the Service availability to a particular location
//   StringBuilder getAllRestaurantsBasedOnParticularLocation(String location);
    //=======================================================
    //To Retrieve Restaurants based on the Service availability to a particular location
   List<RestaurantDto> getAllRestaurantsBasedOnParticularLocation(String location);
}
