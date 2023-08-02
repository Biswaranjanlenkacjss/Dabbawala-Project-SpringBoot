package com.dabbawala.service;

import com.dabbawala.dto.CustomerCartDto;

public interface CustomerCartService {
    //===================================================================
    //Register or Add recipes To Cart
    StringBuilder addRecipesToCart(CustomerCartDto customerCartDto);
    //===================================================================
    //To delete a Particular Recipe From Customer cart
   // String deleteSingleRecipeFromCustomerCart(int customerCartId,int recipeId);
    //===================================================================
    //To Add Recipe To Exiting Cart(i.e Update Customer Cart)
    String updateRecipe(CustomerCartDto  customerCartDto);
    //===================================================================
}
