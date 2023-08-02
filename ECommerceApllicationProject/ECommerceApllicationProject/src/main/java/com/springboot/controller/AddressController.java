package com.springboot.controller;

import com.springboot.service.interf.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressController {
    @Autowired
    private AddressService addressService;
//===============================================================
    //To Add the Address to register Customer

}
