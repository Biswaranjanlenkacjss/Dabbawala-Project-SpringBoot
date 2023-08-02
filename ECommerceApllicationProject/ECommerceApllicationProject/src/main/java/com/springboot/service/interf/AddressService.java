package com.springboot.service.interf;

import com.springboot.dto.AddressDto;

public interface AddressService {

    //===========================================================================
    //To Add the Address to register Customer
public String addAddress(String email , String password, AddressDto addressDto);
//===============================================================================
}
