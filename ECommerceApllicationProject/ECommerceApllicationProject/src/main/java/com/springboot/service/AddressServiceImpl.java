package com.springboot.service;

import com.springboot.dto.AddressDto;
import com.springboot.repositery.AddressRepositery;
import com.springboot.service.interf.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepositery addressRepositery;

    //To Add the Address to register Customer

    @Override
    public String addAddress(String email, String password, AddressDto addressDto) {
        return null;
    }
}
