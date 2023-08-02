package com.springboot.service.interf;

import com.springboot.dto.AddressDto;
import com.springboot.dto.CustomerDto;
import com.springboot.repositery.CustomerRepositery;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public interface CustomerService {

    //To Add or Insert  the Customer
     String addCustomer(CustomerDto customerDto);
     //===============================================================

    //To Add Address when Customer is present
    String addAddress(String email,String password, List<AddressDto> addressDtos);
}
