package com.springboot.service;

import com.springboot.dto.AddressDto;
import com.springboot.dto.CustomerDto;
import com.springboot.entity.Address;
import com.springboot.entity.Customer;
import com.springboot.repositery.CustomerRepositery;
import com.springboot.service.interf.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepositery customerRepositery;

    //================================================================================================
    //To Add or Insert  the Customer

    @Override
    public String addCustomer(CustomerDto customerDto) {
        //To Check first ,whether this id is present or not
        try {
            Optional<Customer> customerByEmail = customerRepositery.findById(customerDto.getEmail());

            if (customerByEmail.isPresent()) {

                return "Customer with this ID is Already Exited ";
            } else {
                Customer customer = new Customer();


                customer.setFirstName(customerDto.getFirstName());
                customer.setLastName(customerDto.getLastName());
                customer.setEmail(customerDto.getEmail());
                customer.setMobNo(customerDto.getMobNo());
                customer.setPassword(customerDto.getPassword());
/*
Note
=======
Here  Address shoud be add after the customer register.i.e if Customer Present then only add the address for that particular Customer
*/
                if(customerDto.getAddress() !=null) {
                    List<Address> list = new ArrayList<>();

                    List<AddressDto> address1 = customerDto.getAddress();
                    for (AddressDto d : address1) {
                        Address a = new Address();
                        a.setId(d.getId());
                        a.setLine1(d.getLine1());
                        a.setLine2(d.getLine2());
                        a.setCity(d.getCity());
                        a.setState(d.getState());
                        a.setPostalCode(d.getPostalCode());
                        a.setBillingAddress(d.isBillingAddress());
                        a.setShippingAddress(d.isShippingAddress());
                        list.add(a);
                    }
                    customer.setAddress(list);
                }


                if (customer != null) {
                    customerRepositery.save(customer);
                    return "Customer Added SuccessFully";
                } else {
                    return "Customer Insertion Failed";
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Internal Server Error Please Contact To Admin";
        }


    }//end of Add customer

    //================================================================================================
    //To Add Address when Customer is present

    @Override
    public String addAddress(String email,String password, List<AddressDto> addressDtos) {
        Customer byEmailAndPassword = customerRepositery.findByEmailAndPassword(email, password);
        if(byEmailAndPassword ==null) {
          return "Customer With Email and Password is Not Present";
        }else{
            List<Address> ad=new ArrayList<>();
            for(AddressDto a:addressDtos){
                Address address=new Address();
                address.setId(a.getId());
                address.setLine1(a.getLine1());
                address.setLine2(a.getLine2());
                address.setCity(a.getCity());
                address.setState(a.getState());
                address.setPostalCode(a.getPostalCode());
                address.setShippingAddress(a.isShippingAddress());
                address.setBillingAddress(a.isBillingAddress());
                ad.add(address);
            }
            byEmailAndPassword.setAddress(ad);

            if(byEmailAndPassword!=null) {
                customerRepositery.save(byEmailAndPassword);
                return "Address added Successfully for Eamil;"+email;
            }  else{
                return "Failed to Add Address";
            }
        }

    }//end of
    //================================================================================================

}
