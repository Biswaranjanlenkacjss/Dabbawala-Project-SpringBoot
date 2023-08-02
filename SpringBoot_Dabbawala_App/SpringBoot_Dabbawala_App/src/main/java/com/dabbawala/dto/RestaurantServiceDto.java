package com.dabbawala.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class RestaurantServiceDto {
    private int serviceId;

    private String location;

    private RestaurantDto restaurantDto;
}
