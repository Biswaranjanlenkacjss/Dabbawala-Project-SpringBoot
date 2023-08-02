package com.dabbawala.service.serviceimpl;

import com.dabbawala.dto.RecipeDto;
import com.dabbawala.dto.RestaurantDto;
import com.dabbawala.entity.Recipe;
import com.dabbawala.entity.Restaurant;
import com.dabbawala.repositery.RecipeRepositery;
import com.dabbawala.repositery.RestaurantRepositery;
import com.dabbawala.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RecipeServiceImpl implements RecipeService {
    @Autowired
    private RecipeRepositery recipeRepositery;

    @Autowired
    private RestaurantRepositery restaurantRepositery;
//====================================================================================
    //To Register Recipe
    @Override
    public String registerRecipe(RecipeDto recipeDto) {
        try{
            Optional<Recipe> byId = recipeRepositery.findById(recipeDto.getRecipeId());
            if(byId.isPresent()){
                return "Recipe With This Given Id is Already Present....!!\n Please Provide A different Id.";
            }else {
                Recipe recipe=new Recipe();
                recipe.setRecipeId(recipeDto.getRecipeId());
                recipe.setRecipeName(recipeDto.getRecipeName());
                recipe.setRecipePrice(recipeDto.getRecipePrice());

                RestaurantDto restaurantDto = recipeDto.getRestaurantDto();
                int restaurantId = restaurantDto.getRestaurantId();
                Optional<Restaurant> option = restaurantRepositery.findById(restaurantId);
                if(option.isPresent()){
                    Restaurant restaurant1 = option.get();
                    int restaurantId1 = restaurant1.getRestaurantId();
//                Restaurant restaurant=new Restaurant();
//                restaurant.setRestaurantId(restaurant1.getRestaurantId());
//                restaurant.setRestaurantName(restaurant1.getRestaurantName());
//                restaurant.setRestaurantLocation(restaurant1.getRestaurantLocation());

                    recipe.setRestaurant(restaurant1);

                    if(recipe!=null){
                        recipeRepositery.save(recipe);
                        return "Recipe is Register for Restaurant id  "+restaurantId1+" Successfully";
                    }else{
                        return "Recipe  Registration for Restaurant id  "+restaurantId1+" Failed";
                    }
                }else{
                    return "Restaurant With the Given Id is Not Present\n Please Provide A Valid Restaurant ID. ";
                }
            }


        }catch(Exception e){
            e.printStackTrace();
            return "Sorry,Internal server Error,Please Contact To Admin.";
        }

    }//End Of Register Recipe

    //======================================================================================
    //To Delete Recipe
    @Override
    public String deleteRecipe(int recipeId) {
        try{
            Optional<Recipe> byId = recipeRepositery.findById(recipeId);
            if(byId.isPresent()){
                Recipe recipe = byId.get();

                Restaurant restaurant = recipe.getRestaurant();
                int restaurantId = restaurant.getRestaurantId();

                recipeRepositery.delete(recipe);
                return "Recipe with ID "+recipeId+" Deleted Successfully For the Restaurant Id:"+restaurantId;
            }else{
                return "Sorry ,There is no Recipe  is Available with this Given Id.\n   Recipe Deletion Failed  .\n Please Provide A correct ID";
            }

        }catch (Exception e){
            e.printStackTrace();
            return "Sorry,Internal server Error,Please Contact To Admin.";
        }
    }

    //=======================================================================================
//    //Retrieve Particular recipe based on Location and also Sort Based on Low Price to High Price
//    @Override
//    public StringBuilder getRecipesBasedOnPriceAndLocation(String recipeName) {
//        StringBuilder stringBuilder=new StringBuilder();
//        try{
//            List<Recipe> listOfRecipe = recipeRepositery.getRecipesBasedOnPriceAndLocation(recipeName);
//            stringBuilder.append(recipeName+" Present in the Restaurant:"+"\n"+"===================================================\n");
//            if(!listOfRecipe.isEmpty()){
//               for(Recipe recipe:listOfRecipe){
//                   String recipeName1 = recipe.getRecipeName();
//                   double recipePrice = recipe.getRecipePrice();
//                   Restaurant restaurant = recipe.getRestaurant();
//                   String restaurantName = restaurant.getRestaurantName();
//                   String restaurantLocation = restaurant.getRestaurantLocation();
//
//                   stringBuilder.append("RecipeName:").append(recipeName1+"\n").append("RecipePrice:").append(recipePrice+"\n").
//                           append("RestaurantName:").append(restaurantName+"\n").  append("RestaurantLocation:").append(restaurantLocation+"\n\n");
//               }
//               return stringBuilder;
//            }else{
//                StringBuilder sb=new StringBuilder();
//                return sb.append("No Recipe is Present with that Given Name  ,at any Restaurant. ");
//            }
//
//        }catch(Exception e){
//            e.printStackTrace();
//            StringBuilder sb=new StringBuilder();
//            return sb.append("Sorry,Internal server Error,Please Contact To Admin.");
//        }
//
//    }

    //=======================================================================================
    //Retrieve Particular recipe based on Location and also Sort Based on Low Price to High Price
    @Override
    public List<RecipeDto> getRecipesBasedOnPriceAndLocation(String recipeName) {
        List<RecipeDto> listRecipeDtos=new ArrayList<>();
        try{
            List<Recipe> listOfRecipe = recipeRepositery.getRecipesBasedOnPriceAndLocation(recipeName);
            if(!listOfRecipe.isEmpty()){
                for(Recipe recipe:listOfRecipe){
                    RecipeDto recipeDto=new RecipeDto();
                  recipeDto.setRecipeId(recipe.getRecipeId());
                  recipeDto.setRecipeName( recipe.getRecipeName());
                   recipeDto.setRecipePrice( recipe.getRecipePrice());

                    Restaurant restaurant = recipe.getRestaurant();
                    RestaurantDto restaurantDto=new RestaurantDto();
                    restaurantDto.setRestaurantId(restaurant.getRestaurantId());
                   restaurantDto.setRestaurantName( restaurant.getRestaurantName());
                   restaurantDto.setRestaurantLocation( restaurant.getRestaurantLocation());
                   recipeDto.setRestaurantDto(restaurantDto);

                   listRecipeDtos.add(recipeDto);
                }

            }
        }catch(Exception e){
            e.printStackTrace();
        }
         return listRecipeDtos;
    }
//======================================================================================================
    //Retrieve Recipe For a Particular Restaurant

//    @Override
//    public StringBuilder getAllRecipeBasedOnRestaurantId(int restaurantId) {
//        StringBuilder stringBuilder=new StringBuilder();
//        StringBuilder sb=new StringBuilder();
//        try {
//            Optional<Restaurant> byId = restaurantRepositery.findById(restaurantId);
//            if(byId.isPresent()){
//                List<Recipe> recipeList = recipeRepositery.getAllRecipesBasedOnRestaurant(restaurantId);
//                if(recipeList.size()>0){
//                    stringBuilder.append("The Recipes For the Restaurant ID "+restaurantId+" are:"+"\n===========================================\n");
//                    for (Recipe recipe:recipeList){
//                        Restaurant restaurant = recipe.getRestaurant();
//                        String restaurantName = restaurant.getRestaurantName();
//                        String recipeName = recipe.getRecipeName();
//                        double recipePrice = recipe.getRecipePrice();
//                        String restaurantLocation = restaurant.getRestaurantLocation();
//
//                        stringBuilder.append("RestaurantName:"+restaurantName+"\n"+"RecipeName:"+recipeName+"\n"+"RecipePrice:"+recipePrice+"\n"+
//                                "RestaurantLocation:"+restaurantLocation+"\n\n");
//                    }
//                    return stringBuilder;
//                }else{
//                    return sb.append("There Is No recipe Is available For This Restaurant.");
//                }
//            }else{
//                return sb.append("Restaurant with this Given Id is Not Present. ");
//            }
//
//        }catch (Exception e){
//            e.printStackTrace();
//            StringBuilder sb1=new StringBuilder();
//            return sb1.append("Sorry,Internal server Error,Please Contact To Admin.");
//        }
//
//    }//end Of Retrieve Recipe For a Particular Restaurant
    //=======================================================================================
//Retrieve Recipe For a Particular Restaurant
@Override
public List<RecipeDto> getAllRecipeBasedOnRestaurantId(int restaurantId) {
        List<RecipeDto> recipeDtoList=new ArrayList<>();
    try {
        Optional<Restaurant> byId = restaurantRepositery.findById(restaurantId);
        if(byId.isPresent()){
            List<Recipe> recipeList = recipeRepositery.getAllRecipesBasedOnRestaurant(restaurantId);
            if(recipeList.size()>0){
                for (Recipe recipe:recipeList){
                    RecipeDto recipeDto=new RecipeDto();
                    recipeDto.setRecipeId(recipe.getRecipeId());
                    recipeDto.setRecipeName( recipe.getRecipeName());
                   recipeDto.setRecipePrice( recipe.getRecipePrice());

                    Restaurant restaurant = recipe.getRestaurant();
                    RestaurantDto restaurantDto=new RestaurantDto();
                    restaurantDto.setRestaurantId(restaurant.getRestaurantId());
                    restaurantDto.setRestaurantName( restaurant.getRestaurantName());
                    restaurantDto.setRestaurantLocation( restaurant.getRestaurantLocation());
                    recipeDto.setRestaurantDto(restaurantDto);

                  recipeDtoList.add(recipeDto);
                }

            }
        }

    }catch (Exception e){
        e.printStackTrace();
    }
        return recipeDtoList;
}//end Of Retrieve Recipe For a Particular Restaurant
    //================================================================================================
}
