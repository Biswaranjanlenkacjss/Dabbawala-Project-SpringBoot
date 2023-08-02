package com.springboot.dto;

import com.springboot.entity.Address;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

public class CustomerDto {

    private String email;


    private String firstName;


    private String lastName;



    private String password;

    private String mobNo;


    private List<AddressDto> address;


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobNo() {
        return mobNo;
    }

    public void setMobNo(String mobNo) {
        this.mobNo = mobNo;
    }

    public List<AddressDto> getAddress() {
        return address;
    }

    public void setAddress(List<AddressDto> address) {
        this.address = address;
    }

    public CustomerDto() {
    }

    public CustomerDto(String email, String firstName, String lastName, String password, String mobNo, List<AddressDto> address) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.mobNo = mobNo;
        this.address = address;
    }

    @Override
    public String toString() {
        return "CustomerDto{" +
                "email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", password='" + password + '\'' +
                ", mobNo='" + mobNo + '\'' +
                ", address=" + address +
                '}';
    }
}