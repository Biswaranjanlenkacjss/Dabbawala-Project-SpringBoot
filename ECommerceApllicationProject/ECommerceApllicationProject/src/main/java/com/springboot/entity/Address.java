package com.springboot.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="customer_address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull(message = "line1 Should not be null")
    @NotBlank
    private String line1;

    private String line2;

    @NotNull(message = "city should not be null")
    @NotBlank
    private String city;

    @NotNull(message = "state should not be null")
    @NotBlank
    private String state;

    @NotNull(message = "postalcode should not be null")
   // @NotBlank
    private int postalCode;

    private boolean shippingAddress;

    private boolean billingAddress;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLine1() {
        return line1;
    }

    public void setLine1(String line1) {
        this.line1 = line1;
    }

    public String getLine2() {
        return line2;
    }

    public void setLine2(String line2) {
        this.line2 = line2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    public boolean isShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(boolean shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public boolean isBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(boolean billingAddress) {
        this.billingAddress = billingAddress;
    }

    public Address(int id, String line1, String line2, String city, String state, int postalCode, boolean shippingAddress, boolean billingAddress) {
        this.id = id;
        this.line1 = line1;
        this.line2 = line2;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
        this.shippingAddress = shippingAddress;
        this.billingAddress = billingAddress;
    }

    public Address() {
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", line1='" + line1 + '\'' +
                ", line2='" + line2 + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", postalCode=" + postalCode +
                ", shippingAddress=" + shippingAddress +
                ", billingAddress=" + billingAddress +
                '}';
    }
}
