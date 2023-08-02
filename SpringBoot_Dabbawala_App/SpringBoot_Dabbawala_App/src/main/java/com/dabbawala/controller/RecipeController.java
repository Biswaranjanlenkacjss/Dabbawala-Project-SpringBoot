package com.dabbawala.controller;

import com.dabbawala.dto.RecipeDto;
import com.dabbawala.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RecipeController {
    @Autowired
    private RecipeService recipeService;
    //=========================================================
    @PostMapping("/recipe")
    public ResponseEntity<String> registerRecipe(@RequestBody RecipeDto recipeDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(recipeService.registerRecipe(recipeDto));
    }
    //==============================================================================
    //To Delete Recipe
    @DeleteMapping("/recipe/{recipeId}")
    public ResponseEntity<String> deleteRestaurantService(@PathVariable int recipeId){
        return  ResponseEntity.status(HttpStatus.OK).body(recipeService.deleteRecipe(recipeId));
    }
    //================================================================================
    //Retrieve Particular recipe based on Location and also Sort Based on Low Price to High Price
//    @GetMapping("/recipe/{recipeName}")
//    public ResponseEntity<StringBuilder> getRecipesBasedOnPriceAndLocation(@PathVariable String recipeName){
//        return ResponseEntity.status(HttpStatus.OK).body(recipeService.getRecipesBasedOnPriceAndLocation(recipeName));
//    }
    //=================================================================================
    @GetMapping("/recipe/{recipeName}")
    public ResponseEntity<List<RecipeDto>> getRecipesBasedOnPriceAndLocation(@PathVariable String recipeName){
        List<RecipeDto> recipesBasedOnPriceAndLocation = recipeService.getRecipesBasedOnPriceAndLocation(recipeName);
        if(!recipesBasedOnPriceAndLocation.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body(recipesBasedOnPriceAndLocation);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    //================================================================================
//    //Retrieve Recipe For a Particular Restaurant
//    @GetMapping("/recipe/restaurant/{restaurantId}")
//    public  ResponseEntity< StringBuilder> getAllRecipeBasedOnRestaurantId(@PathVariable int restaurantId) {
//        return ResponseEntity.status(HttpStatus.OK).body(recipeService.getAllRecipeBasedOnRestaurantId(restaurantId));
//    }
    //==================================================================================
    //Retrieve Recipe For a Particular Restaurant
    @GetMapping("/recipe/restaurant/{restaurantId}")
    public  ResponseEntity< List<RecipeDto>> getAllRecipeBasedOnRestaurantId(@PathVariable int restaurantId) {
        List<RecipeDto> allRecipeBasedOnRestaurantId = recipeService.getAllRecipeBasedOnRestaurantId(restaurantId);
        if(!allRecipeBasedOnRestaurantId.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(allRecipeBasedOnRestaurantId);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    //==================================================================================
}
