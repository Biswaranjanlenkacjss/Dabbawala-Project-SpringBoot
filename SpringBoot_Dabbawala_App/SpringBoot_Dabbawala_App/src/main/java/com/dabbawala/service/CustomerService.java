package com.dabbawala.service;

import com.dabbawala.dto.CustomerDto;
import com.dabbawala.entity.Customer;

import java.util.List;

public interface CustomerService {
    //=====================================================
    //To Save or Register the Customer(Customer Should be 18 Years Old)
    String  registerCustomer(CustomerDto customerDto);
    //=====================================================
    //To Get All The Customer
    List<CustomerDto>  getAllTheCustomer();
    //=====================================================
    //To Get Single User
    CustomerDto getSingleCustomer(String emailId);
    //=====================================================
    //Update Customer
    String updateCustomer(CustomerDto customerDto);
    //=====================================================
    //Delete Customer
    String deleteCustomer(String emailId);
    //=====================================================
}
