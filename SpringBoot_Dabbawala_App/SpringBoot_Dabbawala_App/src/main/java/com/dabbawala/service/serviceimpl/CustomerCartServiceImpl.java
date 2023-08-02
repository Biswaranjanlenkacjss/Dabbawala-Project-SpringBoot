package com.dabbawala.service.serviceimpl;

import com.dabbawala.dto.CustomerCartDto;
import com.dabbawala.dto.CustomerDto;
import com.dabbawala.dto.RecipeDto;
import com.dabbawala.dto.RestaurantDto;
import com.dabbawala.entity.Customer;
import com.dabbawala.entity.CustomerCart;
import com.dabbawala.entity.Recipe;
import com.dabbawala.entity.Restaurant;
import com.dabbawala.repositery.CustomerCartRepositery;
import com.dabbawala.repositery.CustomerRepositery;
import com.dabbawala.repositery.RecipeRepositery;
import com.dabbawala.service.CustomerCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerCartServiceImpl implements CustomerCartService {

    @Autowired
    private CustomerCartRepositery customerCartRepositery;

    @Autowired
    private CustomerRepositery customerRepositery;

    @Autowired
    private RecipeRepositery recipeRepositery;
    //========================================================================================
    //Register or Add recipes To Cart

    @Override
    public StringBuilder addRecipesToCart(CustomerCartDto customerCartDto) {
        int restaurantId = 0;
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        try {
            Optional<Customer> byId = customerRepositery.findById(customerCartDto.getCustomerDto().getEmail());
            if (byId.isPresent()) {
                Optional<CustomerCart> option = customerCartRepositery.findById(customerCartDto.getCartId());
                if (option.isPresent()) {
                    return sb.append("Cart is already Present With This Cart Id.\n Please Provide A Unique and Valid Customer Cart ID.");
                } else {
                    CustomerCart customerCart = new CustomerCart();
                    customerCart.setCartId(customerCartDto.getCartId());

                    CustomerCart customerCartByEmail = customerCartRepositery.getCustomerCartByEmail(customerCartDto.getCustomerDto().getEmail());
                    if (customerCartByEmail == null) {
                        Customer customer = byId.get();
                        customerCart.setCustomer(customer);
                    } else {
                        StringBuilder sb2 = new StringBuilder();
                        return sb2.append("This Customer Email Id is Already Present in ServiceCart.\nPlease Provide A Another Valid Email Id For Customer.");
                    }

                    List<RecipeDto> recipeDtos = customerCartDto.getRecipeDtos();
                    int count = 0;
                    List<Recipe> recipeList = new ArrayList<>();
                    for (RecipeDto dto : recipeDtos) {
                        Optional<Recipe> byId1 = recipeRepositery.findById(dto.getRecipeId());
                        if (byId1.isPresent()) {
                            Recipe recipe = byId1.get();

                            if (count == 0) {
                                restaurantId = recipe.getRestaurant().getRestaurantId();
                                count++;
                                recipeList.add(recipe);
                            } else {
                                int restaurantId1 = recipe.getRestaurant().getRestaurantId();
                                if (restaurantId == restaurantId1) {
                                    recipeList.add(recipe);
                                    restaurantId = restaurantId1;
                                } else {
                                    StringBuilder sb1 = new StringBuilder();
                                    return sb1.append("Please Add Recipes From Same Restaurant.");
                                }
                            }
                            customerCart.setRecipes(recipeList);
                        } else {
                            return sb.append("Recipe Not Found With This ID");
                        }

                    }
                    if (customerCart != null) {
                        customerCartRepositery.save(customerCart);
                        return stringBuilder.append("Recipes Are Added To The Cart Successfully");
                    } else {
                        return stringBuilder.append("Sorry,Recipes Failed To Adding To Cart.");
                    }
                }

            } else {
                return sb.append("Customer is Not Present With the Given Customer Id.\n Please Check And Provide A valid Customer Id");
            }

        } catch (Exception e) {
            e.printStackTrace();
            StringBuilder sb1 = new StringBuilder();
            return sb1.append("Sorry,Internal server Error,Please Contact To Admin.");
        }

    }

    //========================================================================================
    //To delete a Particular Recipe From Customer cart
 //   @Transactional
//    @Override
//    public String deleteSingleRecipeFromCustomerCart(int customerCartId, int recipeId) {
//        try{
//            Optional<CustomerCart> byId = customerCartRepositery.findById(customerCartId);
//            if(byId.isPresent()){
//                CustomerCart customerCart = byId.get();
//                List<Recipe> recipes = customerCart.getRecipes();
//                int count=0;
//                for(Recipe r:recipes){
//                    int recipeId1 = r.getRecipeId();
//                    if(recipeId1==recipeId){
//                        count++;
//                        if(count==1){
//                            customerCartRepositery.deleteSingleRecipeFromCustomerCart(customerCartId, recipeId);
//                            return "Recipe "+recipeId+" deleted Successfully from CartId:"+customerCart+".";
//                        }
//                    }
//                }
//                if(count==0){
//                    return "Recipe Not Found In This Cart With this ID";
//                }
//
//            }else{
//                return "Customer Cart Id is Not Found.Please, Provide A valid customer Id ";
//            }
//        }catch(Exception e){
//            e.printStackTrace();
//            return "Internal Server Error Please Contact To Admin";
//        }
//        return null;
//    }

    //========================================================================================
    //To Add Recipe To Exiting Cart(i.e Update Customer Cart)

    @Override
    public String updateRecipe(CustomerCartDto customerCartDto) {
        int restaurantId = 0;
        int restaurantId2 = 0;
        try {
            Optional<CustomerCart> byId = customerCartRepositery.findById(customerCartDto.getCartId());
            if (byId.isPresent()) {
                CustomerCart customerCart = byId.get();

                customerCart.setCartId(customerCartDto.getCartId());

                CustomerDto customerDto = customerCartDto.getCustomerDto();
                Optional<Customer> byId1 = customerRepositery.findById(customerDto.getEmail());
                Customer customer = byId1.get();
                customerCart.setCustomer(customer);

                List<Recipe> recipeList = new ArrayList<>();
                List<RecipeDto> recipeDtos = customerCartDto.getRecipeDtos();
                List<Recipe> recipes1 = customerCart.getRecipes();

                if (recipes1.size() == 0) {
                    int count = 0;
                    for (RecipeDto dto : recipeDtos) {
                        Optional<Recipe> byId2 = recipeRepositery.findById(dto.getRecipeId());
                        if (byId2.isPresent()) {
                            Recipe recipe = byId2.get();

                            if (count == 0) {
                                restaurantId = recipe.getRestaurant().getRestaurantId();
                                count++;
                                recipeList.add(recipe);
                            } else {
                                int restaurantId1 = recipe.getRestaurant().getRestaurantId();
                                if (restaurantId == restaurantId1) {
                                    recipeList.add(recipe);
                                    restaurantId = restaurantId1;
                                } else {
                                    return "Please Add Recipes From Same Restaurant.";
                                }
                            }
                            customerCart.setRecipes(recipeList);
                        } else {
                            return "Recipe Not Found With This ID";
                        }

                    }
                    customerCartRepositery.save(customerCart);
                    return "Cart Is Updated Successfully";
                } else {
                    for (Recipe r : recipes1) {
                        restaurantId2 = r.getRestaurant().getRestaurantId();
                    }
                    int count1 = 0;
                    for (RecipeDto recipeDto : recipeDtos) {
                        Optional<Recipe> byId2 = recipeRepositery.findById(recipeDto.getRecipeId());
                        if (byId2.isPresent()) {
                            Recipe recipe = byId2.get();
                            int restaurantId1 = recipe.getRestaurant().getRestaurantId();
                            if (restaurantId2 == restaurantId1) {
                                recipeList.add(recipe);
                                restaurantId2 = restaurantId1;
                            }
                        }
                    }
                    customerCart.setRecipes(recipeList);
                    customerCartRepositery.save(customerCart);
                    return "Cart Updated Successfully  ";
                }

            } else {
                return "Customer Cart is Not Present with this Id";
            }

        } catch (Exception e) {
            e.printStackTrace();
            return "Internal Server Error Please Contact To Admin";
        }
        //return null;
    }
}
