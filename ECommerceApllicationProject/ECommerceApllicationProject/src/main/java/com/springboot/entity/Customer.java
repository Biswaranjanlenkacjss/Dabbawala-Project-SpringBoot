package com.springboot.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;


import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="customer_details")
public class Customer {

    @NotNull(message = "email should not be null")
    @NotBlank
    @Email
    @Id
    private String email;

    @NotNull(message = "firstname should not be null")
    @NotBlank
    private String firstName;

    @NotNull(message = "lastname should be null")
    @NotBlank
    private String lastName;


    @NotNull
    @Size(min = 4, max = 10, message = "password min length is 5 and Max ")
    @NotBlank
    private String password;

    @Column(unique = true)
    @NotNull(message = "mobile no should be ")
    @Size(min = 10, max = 10, message = "mobile no should be 10 digits only")
    @NotBlank
    private String mobNo;


    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_id", referencedColumnName = "email")
    private List<Address> address=new ArrayList<>();

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

    public List<Address> getAddress() {
        return address;
    }

    public void setAddress(List<Address> address) {
        this.address = address;
    }

    public Customer() {
    }

    public Customer(String email, String firstName, String lastName, String password, String mobNo, List<Address> address) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.mobNo = mobNo;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", password='" + password + '\'' +
                ", mobNo='" + mobNo + '\'' +
                ", address=" + address +
                '}';
    }
}