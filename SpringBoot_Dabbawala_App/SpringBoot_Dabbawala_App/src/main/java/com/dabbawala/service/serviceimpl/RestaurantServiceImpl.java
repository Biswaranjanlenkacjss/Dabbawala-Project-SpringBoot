package com.dabbawala.service.serviceimpl;

import com.dabbawala.dto.RestaurantDto;
import com.dabbawala.entity.Customer;
import com.dabbawala.entity.Restaurant;
import com.dabbawala.repositery.RestaurantRepositery;
import com.dabbawala.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RestaurantServiceImpl implements RestaurantService {
    @Autowired
    private RestaurantRepositery restaurantRepositery;

    //=============================================================
    //To Register Restaurant
    @Override
    public String registerRestaurant(RestaurantDto resturantDto) {
        Restaurant  restaurant =null;
        try{
            Optional<Restaurant> byId = restaurantRepositery.findById(resturantDto.getRestaurantId());
            if(byId.isPresent()){
                return "Restaurant With  This Given Id is Already Present.";
            }else {
                restaurant= new Restaurant();
                restaurant.setRestaurantId(resturantDto.getRestaurantId());
                restaurant.setRestaurantName(resturantDto.getRestaurantName());
                restaurant.setRestaurantLocation(resturantDto.getRestaurantLocation());

                if(restaurant!=null){
                    restaurantRepositery.save(restaurant);
                    return "Restaurant Register Successfully";
                }else{
                    return "Sorry,Restaurant Registration Failed";
                }
            }
        }catch(Exception e){
            e.printStackTrace();
            return "Sorry,Internal Server Error,Please Contact to Admin";
        }
    }//End Of Register Restaurant

//=================================================================
//To get Single Restaurant
    @Override
    public RestaurantDto getSingleRestaurant(int restaurantId) {
        RestaurantDto restaurantDto=null;
        try{
            Optional<Restaurant> byId = restaurantRepositery.findById(restaurantId);
            if(byId.isPresent()){
                Restaurant restaurant = byId.get();
                 restaurantDto=new RestaurantDto();
                restaurantDto.setRestaurantId(restaurant.getRestaurantId());
                restaurantDto.setRestaurantName(restaurant.getRestaurantName());
                restaurantDto.setRestaurantLocation(restaurant.getRestaurantLocation());
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return restaurantDto;
    }//end of Get single Restaurant
//====================================================================
//To get All Restaurant
    @Override
    public List<RestaurantDto> getAllRestaurant() {
        List<RestaurantDto> restaurantDtoList=new ArrayList<>();
        try{
            List<Restaurant> all = restaurantRepositery.findAll();
            for(Restaurant r:all){
                RestaurantDto dto=new RestaurantDto();
                dto.setRestaurantId(r.getRestaurantId());
                dto.setRestaurantName(r.getRestaurantName());
                dto.setRestaurantLocation(r.getRestaurantLocation());
                restaurantDtoList.add(dto);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return restaurantDtoList;
    }//end of getAll the restaurant
//=========================================================================
    //To Update Restaurant
    @Override
    public String updateRestaurant(RestaurantDto restaurantDto) {
        try{
            Optional<Restaurant> byId = restaurantRepositery.findById(restaurantDto.getRestaurantId());
            if(byId.isPresent()){
                Restaurant restaurant = byId.get();
                restaurant.setRestaurantName(restaurantDto.getRestaurantName());
                restaurant.setRestaurantLocation(restaurantDto.getRestaurantLocation());

                if(restaurant!=null){
                    restaurantRepositery.save(restaurant);
                    return "Restaurant Updated Successfully.\n      -:THANK YOU:- ";
                }else{
                    return "Restaurant Updation Failed .Please Provide all the fields Correctly ";
                }
            }else{
                return "Restaurant With is this Given Id Is Not Present.\n Please Provide A Valid Restaurant Id.";
            }

        }catch(Exception e){
            e.printStackTrace();
            return "Sorry,Internal Server Error,Please Contact to Admin";
        }

    }//end of Update Customer
    //=========================================================================
    //Delete Restaurant
    @Override
    public String deleteRestaurant(int restaurantId) {
        try{
            Optional<Restaurant> byId = restaurantRepositery.findById(restaurantId);
            if (byId.isPresent()) {
                Restaurant restaurant = byId.get();
                restaurantRepositery.delete(restaurant);
                return "Restaurant Deleted Successfully";
            }else{
                return "Restaurant Deletion Failed...!!!\n Please Provide A valid Email Id.";
            }

        }catch(Exception e){
            e.printStackTrace();
            return "Sorry,Internal Server Error,Please Contact to Admin";
        }
    }//end of Delete Customer
//=========================================================================
}
