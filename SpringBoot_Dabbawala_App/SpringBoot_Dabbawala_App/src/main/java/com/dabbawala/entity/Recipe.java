package com.dabbawala.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Recipe {

    @Id
    private int recipeId;

    private String recipeName;

    private double recipePrice;

    @ManyToOne
    @JoinColumn(name = "restaurant_id_fk")
    private Restaurant restaurant;
}
