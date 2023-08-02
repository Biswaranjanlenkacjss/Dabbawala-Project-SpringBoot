package com.dabbawala.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class RecipeDto {
    private int recipeId;

    private String recipeName;

    private double recipePrice;

    private RestaurantDto  restaurantDto;
}
