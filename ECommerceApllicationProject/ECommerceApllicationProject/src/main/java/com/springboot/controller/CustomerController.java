package com.springboot.controller;

import com.springboot.dto.CustomerDto;
import com.springboot.service.interf.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    //================================================================================================
    //To Add or Insert  the Customer
    @PostMapping("/customer")
    public String addCustomer(@RequestBody CustomerDto customerDto) {
        return customerService.addCustomer(customerDto);
    }
//================================================================================================
    //To Add Address when Customer is present
}
