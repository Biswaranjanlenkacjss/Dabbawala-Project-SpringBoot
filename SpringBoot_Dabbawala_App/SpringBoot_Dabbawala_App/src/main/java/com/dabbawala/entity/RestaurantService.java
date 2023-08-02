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
public class RestaurantService {
    @Id
    private int serviceId;

    private String location;

    @ManyToOne
    @JoinColumn(name = "restaurantId_fk")
    private Restaurant restaurant;
}
