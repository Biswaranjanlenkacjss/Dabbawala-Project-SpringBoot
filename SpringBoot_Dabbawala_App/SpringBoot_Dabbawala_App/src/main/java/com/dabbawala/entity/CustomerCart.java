package com.dabbawala.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class CustomerCart {
    @Id
    private int cartId;

    @OneToOne(cascade = CascadeType.ALL)
    private Customer  customer;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Recipe> recipes;
}
