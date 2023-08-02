package com.dabbawala.repositery;

import com.dabbawala.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepositery extends JpaRepository<Restaurant,Integer> {
}
