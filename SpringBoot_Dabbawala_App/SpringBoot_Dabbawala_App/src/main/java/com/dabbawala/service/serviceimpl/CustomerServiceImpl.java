package com.dabbawala.service.serviceimpl;

import com.dabbawala.dto.CustomerDto;
import com.dabbawala.dto.MembershipTypeDto;
import com.dabbawala.entity.Customer;
import com.dabbawala.entity.MembershipType;
import com.dabbawala.repositery.CustomerRepositery;
import com.dabbawala.repositery.MembershipTypeRepositery;
import com.dabbawala.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepositery customerRepositery;

    @Autowired
    private MembershipTypeRepositery typeRepositery;

    //========================================================
    //To Calculate the Age Of the Customer
    public static int calculateAge(LocalDate birthDate, LocalDate currentDate) {
        if ((birthDate != null) && (currentDate != null)) {
            return Period.between(birthDate, currentDate).getYears();
        } else {
            return 0;
        }
    }//End Of Calculate Age
//========================================================
    //To Check MemberShip id with membership type combination

    public static boolean checkMembershipIdWithType(int membershipId, String membershipType) {
        if ((membershipId == 1 && membershipType.equalsIgnoreCase("Normal")) || (membershipId == 2 && membershipType.equalsIgnoreCase("Platinum"))) {
            return true;
        } else {
            return false;
        }
    }//end of CheckMembership method

    //========================================================
    //To Save or Register the Customer(note-: Customer Should be 18 Years Old)
    @Override
    public String registerCustomer(CustomerDto customerDto) {
        Customer customer = null;
        try {
            //First Check   whether Customer with is email id is present or not
            Optional<Customer> option = customerRepositery.findById(customerDto.getEmail());
            if (option.isPresent()) {
                return "Customer With this Email id " + customerDto.getEmail() + "  is already Present,\nPlease Provide Different EMAIL ID.";
            } else {
                int i = calculateAge(customerDto.getDateOfBirth(), LocalDate.now());
                if (i >= 18) {
                    customer = new Customer();
                    customer.setEmail(customerDto.getEmail());
                    customer.setName(customerDto.getName());
                    customer.setDateOfBirth(customerDto.getDateOfBirth());
                    customer.setPhoneNo(customerDto.getPhoneNo());


                    //To Get MemberShipType From MembershipTypeDto
                    MembershipTypeDto membershipTypeDto = customerDto.getMembershipTypeDto();
                    int id = membershipTypeDto.getId();
                    Optional<MembershipType> typeId = typeRepositery.findById(id);
                    if (typeId.isPresent()) {
                        MembershipType type1 = typeId.get();
                        String membershipType1 = type1.getMembershipType();
                        MembershipType type = new MembershipType();
                        type.setId(id);
                        type.setMembershipType(membershipType1);
                        customer.setMembershipType(type);

                        if (customer != null) {
                            customerRepositery.save(customer);
                            return "Customer Register Successfully!!! \n THANK YOU";
                        } else {
                            return "Customer Registration Failed....SomeThing Went To Wrong....Sorry!!!";
                        }
                    } else {
                        return "Please Enter A Valid Member Ship Id...\n 1 for Normal Membership \n 2 for Platinum Membership";
                    }

                } else {
                    return "You Are Not Eligible To Register...!!!You Age Should be 18+. ";
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            return "Internal Server Error,Please Contact To Admin";

        }

    }//end of register Customer


    //========================================================
    //To Get All The Customer
    @Override
    public List<CustomerDto> getAllTheCustomer() {
        ArrayList<CustomerDto> allCustomers = new ArrayList<>();
        try {
            List<Customer> all = customerRepositery.findAll();
            for (Customer c : all) {
                CustomerDto cutomerDto = new CustomerDto();
                cutomerDto.setEmail(c.getEmail());
                cutomerDto.setName(c.getName());
                cutomerDto.setPhoneNo(c.getPhoneNo());
                cutomerDto.setDateOfBirth(c.getDateOfBirth());

                MembershipType membershipType = c.getMembershipType();
                MembershipTypeDto membershipTypeDto = new MembershipTypeDto();
                membershipTypeDto.setId(membershipType.getId());
                membershipTypeDto.setMembershipType(membershipType.getMembershipType());

                cutomerDto.setMembershipTypeDto(membershipTypeDto);

                allCustomers.add(cutomerDto);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return allCustomers;
    }//end Of get All The customer

    //===========================================================
    //Get Single Customer
    @Override
    public CustomerDto getSingleCustomer(String emailId) {
        CustomerDto customerDto = null;
        try {
            Optional<Customer> byId = customerRepositery.findById(emailId);
            if (byId.isPresent()) {
                Customer customer = byId.get();
                customerDto = new CustomerDto();
                customerDto.setEmail(customer.getEmail());
                customerDto.setName(customer.getName());
                customerDto.setPhoneNo(customer.getPhoneNo());
                customerDto.setDateOfBirth(customer.getDateOfBirth());

                MembershipType membershipType = customer.getMembershipType();
                MembershipTypeDto membershipTypeDto = new MembershipTypeDto();
                membershipTypeDto.setId(membershipType.getId());
                membershipTypeDto.setMembershipType(membershipType.getMembershipType());

                customerDto.setMembershipTypeDto(membershipTypeDto);

            }
//            if(customerDto!=null){
//                return customerDto;
//            }else{
//                return new ResourceNotFoundException ("Customer With this Email Id Not Found.");
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return customerDto;
    }//end of get Single Customer


    //===========================================================
    //Update Customer
    @Override
    public String updateCustomer(CustomerDto customerDto) {
        try {
            Optional<Customer> byId = customerRepositery.findById(customerDto.getEmail());
            if (byId.isPresent()) {
                Customer customer = byId.get();
                customer.setEmail(customerDto.getEmail());
                customer.setName(customerDto.getName());
                customer.setPhoneNo(customerDto.getPhoneNo());

                int i = calculateAge(customerDto.getDateOfBirth(), LocalDate.now());
                if (i >= 18) {
                    customer.setDateOfBirth(customerDto.getDateOfBirth());

                    MembershipTypeDto membershipTypeDto = customerDto.getMembershipTypeDto();
                    int id = membershipTypeDto.getId();
                    Optional<MembershipType> typeId = typeRepositery.findById(id);
                    if (typeId.isPresent()) {
                        MembershipType type1 = typeId.get();
                        String membershipType1 = type1.getMembershipType();
                        MembershipType type = new MembershipType();
                        type.setId(id);
                        type.setMembershipType(membershipType1);
                        customer.setMembershipType(type);

                        if(customer!=null){
                            customerRepositery.save(customer);
                            return "Customer Updated Successfully...!!!\n          -:THANK YOU:-";
                        }else{
                            return "Customer Updation  Failed...Please Provide All The Fields Correctly.";
                        }
                    }else{
                        return "Please Enter A Valid Member Ship Id...\n 1 for Normal Membership \n 2 for Platinum Membership";
                    }
                }else{
                    return "Please Enter A Valid Date Of Birth,The User Should be 18+. ";
                }
            } else {
                return "Customer With This ID is Not Present";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Sorry,Internal Server Error ,Please Contact To Admin.";
        }

    }//End Of Customer Updation
    //=================================================================================
    //Delete Customer
    @Override
    public String deleteCustomer(String emailId) {
        try{
            Optional<Customer> byId = customerRepositery.findById(emailId);
            if (byId.isPresent()) {
                //customerRepositery.deleteById(emailId);
                Customer customer = byId.get();
                customerRepositery.delete(customer);
                return "Customer Deleted Successfully";
            }else{
                return "Customer Deletion Failed...!!!\n Please Provide A valid Email Id.";
            }
        }catch (Exception e){
            e.printStackTrace();
            return "Sorry,Internal Server Error ,Please Contact To Admin.";
        }
    }
    //=================================================================================
}
