package com.dabbawala.service;

import com.dabbawala.dto.RecipeDto;

import java.util.List;

public interface RecipeService {
    //===================================================
    //To Register Recipe
     String registerRecipe(RecipeDto recipeDto);
    //===================================================
    //To Delete the Recipe
    String deleteRecipe(int recipeId);
    //===================================================
    //Retrieve Particular recipe based on Location and also Sort Based on Low Price to High Price
//    StringBuilder getRecipesBasedOnPriceAndLocation(String recipeName);
//===================================================
    //Retrieve Particular recipe based on Location and also Sort Based on Low Price to High Price
    List<RecipeDto> getRecipesBasedOnPriceAndLocation(String recipeName);
    //===================================================
    //Retrieve Recipe For a Particular Restaurant
//    StringBuilder getAllRecipeBasedOnRestaurantId(int restaurantId);
    //===================================================
    //Retrieve Recipe For a Particular Restaurant
    List<RecipeDto> getAllRecipeBasedOnRestaurantId(int restaurantId);
    //===================================================
}
