package com.dabbawala.repositery;

import com.dabbawala.entity.CustomerCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerCartRepositery extends JpaRepository<CustomerCart,Integer> {

    //==============================================================================
    //To Get Particular Email From Customer Cart
    @Query(value = "select * from customer_cart where customer_email=?1",nativeQuery = true)
    CustomerCart getCustomerCartByEmail(String emailId);
    //===============================================================================
    //To delete a Particular Recipe From Customer cart
//    @Modifying
//    @Query(value = "delete from  customer_cart  where customer_cart_cart_id=?1 and recipes_recipe_id=?2",nativeQuery = true)
//    void deleteSingleRecipeFromCustomerCart(int customerCartId,int recipeId);
    //===============================================================================
}
