package com.dabbawala.repositery;

import com.dabbawala.entity.Restaurant;
import com.dabbawala.entity.RestaurantService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestaurantServiceRepositery extends JpaRepository<RestaurantService,Integer> {
    //====================================================================================================
    //To Retrieve Restaurants based on the Service availability to a particular location
//    @Query(value = "select * from restaurant where restaurant_id=(select restaurant_id_fk  from restaurant_service where location=?1)",nativeQuery = true)
//    List<Restaurant> getAllRestaurantsBasedOnParticularLocation(String location);

    //====================================================================================================
    //To Retrieve Restaurants based on the Service availability to a particular location
    @Query(value = "select restaurant_id_fk  from restaurant_service where location=?1",nativeQuery = true)
    List<Integer> getAllRestaurantsBasedOnParticularLocation(String location);
    //====================================================================================================
}
