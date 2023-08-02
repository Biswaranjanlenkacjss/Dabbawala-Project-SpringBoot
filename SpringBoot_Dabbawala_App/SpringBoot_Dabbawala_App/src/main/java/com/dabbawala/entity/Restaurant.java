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
public class Restaurant {

    @Id
    private int  restaurantId;
    private String  restaurantName;
    private String  restaurantLocation;

    @OneToMany(mappedBy ="restaurant" )
    private List<RestaurantService> restaurantServices;
}
