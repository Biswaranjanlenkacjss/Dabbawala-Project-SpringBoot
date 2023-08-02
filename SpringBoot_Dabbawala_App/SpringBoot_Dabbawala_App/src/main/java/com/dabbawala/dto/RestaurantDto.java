package com.dabbawala.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class RestaurantDto {

    private int restaurantId;
    private String restaurantName;

    private String restaurantLocation;

//    private List<RestaurantServiceDto> restaurantServiceDtos;

//    public RestaurantDto(int restaurantId, String restaurantName, String restaurantLocation) {
//        this.restaurantId = restaurantId;
//        this.restaurantName = restaurantName;
//        this.restaurantLocation = restaurantLocation;
//    }
}
