package com.dabbawala.controller;

import com.dabbawala.dto.CustomerCartDto;
import com.dabbawala.service.CustomerCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerCartController {


    @Autowired
    private CustomerCartService customerCartService;
    //==========================================================================
    //Register or Add recipes To Cart
    @PostMapping("/addToCart")
    public ResponseEntity<StringBuilder> addRecipesToCart(@RequestBody CustomerCartDto customerCartDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(customerCartService.addRecipesToCart(customerCartDto));
    }
    //==========================================================================
    //To delete a Particular Recipe From Customer cart
//    @DeleteMapping("/removeRecipe/{customerCartId}/{recipeId}")
//    public ResponseEntity<String > deleteSingleRecipeFromCustomerCart(@PathVariable int customerCartId,@PathVariable int recipeId){
//        return ResponseEntity.status(HttpStatus.OK).body(customerCartService.deleteSingleRecipeFromCustomerCart(customerCartId,recipeId));
//    }
    //==========================================================================
    //To Add Recipe To Exiting Cart(i.e Update Customer Cart)
    @PutMapping("/updateCart")
    public ResponseEntity<String> updateRecipe(@RequestBody CustomerCartDto customerCartDto){
        return ResponseEntity.status(HttpStatus.OK).body(customerCartService.updateRecipe(customerCartDto));
    }
    //==========================================================================
}
