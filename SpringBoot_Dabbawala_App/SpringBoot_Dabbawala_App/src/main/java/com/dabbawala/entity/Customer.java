package com.dabbawala.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name="Dabbawala_Customers")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Customer {

    @Email
   @Id
    private String email;

    @NotNull
    private String name;

    @NotNull
    private String phoneNo;
    @NotNull
    private LocalDate dateOfBirth;

    @ManyToOne
    @JoinColumn(name = "membership_id_fk")
    private MembershipType membershipType;

    @OneToOne(mappedBy = "customer")
    private CustomerCart customerCart;
}
