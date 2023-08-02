package com.dabbawala.controller;

import com.dabbawala.dto.CustomerDto;
import com.dabbawala.exception.ResourceNotFoundException;
import com.dabbawala.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;
//=========================================================
    //To Save or Register the Customer(note-: Customer Should be 18 Years Old)
    @PostMapping("/customer")
    public ResponseEntity<String> registerCustomer(@RequestBody CustomerDto customerDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(customerService.registerCustomer(customerDto));
    }

    //=========================================================
    //To Get All The Customers
    @GetMapping("customer")
    public ResponseEntity<List<CustomerDto> > getAllTheCustomer() {
        return ResponseEntity.ok(customerService.getAllTheCustomer());
    }
    //=========================================================
    //Get Single Customer
    @GetMapping("/customer/single")
    public ResponseEntity<CustomerDto>  getSingleCustomer(@RequestParam String emailId) {
        CustomerDto customerDto = customerService.getSingleCustomer(emailId);
        if (Objects.isNull(customerDto)) {
            throw new ResourceNotFoundException();
        }
        return ResponseEntity.status(HttpStatus.OK).body(customerDto );
    }
    //=========================================================
    //Update Customer
    @PutMapping("/customer")
    public ResponseEntity<String> updateCustomer(@RequestBody CustomerDto customerDto){
        return ResponseEntity.status(HttpStatus.OK).body(customerService.updateCustomer(customerDto));
    }
    //=========================================================
    //Delete Customer
    @DeleteMapping("/customer/{emailId}")
    public ResponseEntity<String> deleteCustomer(@PathVariable String emailId){
        return  ResponseEntity.status(HttpStatus.OK).body(customerService.deleteCustomer(emailId));
    }
    //=========================================================
}
