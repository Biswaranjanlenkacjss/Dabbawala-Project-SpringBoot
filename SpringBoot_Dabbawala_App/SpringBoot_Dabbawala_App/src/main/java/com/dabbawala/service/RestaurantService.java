package com.dabbawala.service;

import com.dabbawala.dto.RestaurantDto;

import java.util.List;

public interface RestaurantService {
    //==================================================
    //To Register Resturant
    String registerRestaurant(RestaurantDto restaurantDto);
    //==================================================
    //Get Single Restaurant
    RestaurantDto getSingleRestaurant(int restaurantId);
    //==================================================
    //Get All The Restaurants
    List<RestaurantDto> getAllRestaurant();
    //==================================================
    //Update Restaurant
    String updateRestaurant(RestaurantDto restaurantDto);
    //==================================================
    //Delete Restaurant
    String deleteRestaurant(int restaurantId);
    //==================================================
}
