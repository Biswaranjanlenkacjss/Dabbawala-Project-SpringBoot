package com.dabbawala.repositery;

import com.dabbawala.entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRepositery extends JpaRepository<Recipe,Integer> {
//===================================================================
    //Retrieve Particular recipe based on Location and also Sort Based on Low Price to High Price
    @Query(value = "select * from recipe where recipe_name=?1 ORDER BY recipe_price",nativeQuery = true)
    public List<Recipe> getRecipesBasedOnPriceAndLocation(String recipeName);
    //===================================================================
    //Retrieve Recipe For a Particular Restaurant
    @Query(value = "select * from recipe where restaurant_id_fk=?1",nativeQuery = true)
     List<Recipe> getAllRecipesBasedOnRestaurant(int restaurantId);
    //===================================================================
}
