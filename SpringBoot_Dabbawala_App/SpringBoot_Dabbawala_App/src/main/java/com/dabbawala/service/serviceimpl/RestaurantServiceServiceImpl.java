package com.dabbawala.service.serviceimpl;

import com.dabbawala.dto.RestaurantDto;
import com.dabbawala.dto.RestaurantServiceDto;
import com.dabbawala.entity.Restaurant;
import com.dabbawala.entity.RestaurantService;
import com.dabbawala.repositery.RestaurantRepositery;
import com.dabbawala.repositery.RestaurantServiceRepositery;
import com.dabbawala.service.RestaurantServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RestaurantServiceServiceImpl implements RestaurantServiceService {
    @Autowired
    private RestaurantServiceRepositery restaurantServiceRepositery;

    @Autowired
    private RestaurantRepositery restaurantRepositery;


    //========================================================================
    //To Register Restaurant Service
    @Override
    public String registerRestaurantService(RestaurantServiceDto restaurantServiceDto) {
        try {
            Optional<RestaurantService> byId = restaurantServiceRepositery.findById(restaurantServiceDto.getServiceId());
            if (byId.isPresent()) {
                return "Service With Given ID is Already Present,Please Provide A Different Service  ID.";
            } else {
                RestaurantService restaurantService = new RestaurantService();
                restaurantService.setServiceId(restaurantServiceDto.getServiceId());
                restaurantService.setLocation(restaurantServiceDto.getLocation());

                RestaurantDto restaurantDto = restaurantServiceDto.getRestaurantDto();
                Optional<Restaurant> option = restaurantRepositery.findById(restaurantDto.getRestaurantId());
                if (option.isPresent()) {
                    Restaurant restaurant = option.get();
                    int restaurantId = restaurant.getRestaurantId();
                    restaurantService.setRestaurant(restaurant);

                    if (restaurantService != null) {
                        restaurantServiceRepositery.save(restaurantService);
                        return "Restaurant Service For Restaurant ID " + restaurantId + " Register Successfully ";
                    } else {
                        return "Restaurant Service For Restaurant ID " + restaurantId + " Register Failure.\n    Sorry,Please Try Again.";
                    }

                } else {
                    return "Restaurant  with this Given Id is not Present.\n Please Check The Restaurant and Provide A valid Restaurant Id. ";
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
            return " Sorry,Internal Server Error,Please Contact To Admin.";
        }
    }//end Register Restaurant  Service

    //==========================================================================================
    //To Delete Restaurant Service
    @Override
    public String deleteRestaurantService(int serviceId) {
        try {
            Optional<RestaurantService> byId = restaurantServiceRepositery.findById(serviceId);
            if (byId.isPresent()) {
                RestaurantService restaurantService = byId.get();

                Restaurant restaurant = restaurantService.getRestaurant();
                int restaurantId = restaurant.getRestaurantId();
                restaurantServiceRepositery.delete(restaurantService);

                return "Restaurant Service with ID " + serviceId + " Deleted Successfully For the Restaurant Id:" + restaurantId;
            } else {
                return "Sorry ,There is no Restaurant Service is Available with this Given Id.\n   RestaurantService Deletion Failed  .";
            }

        } catch (Exception e) {
            e.printStackTrace();
            return "Sorry,Internal Server Error,Please Contact To Admin";
        }

    }//End of delete Restaurant Service


    //==========================================================================================
    //To Retrieve Restaurants based on the Service availability to a particular location
//    @Override
//    public StringBuilder getAllRestaurantsBasedOnParticularLocation(String location) {
//        try{
//            List<Restaurant> allRestaurants = restaurantServiceRepositery.getAllRestaurantsBasedOnParticularLocation(location);
//            if(!allRestaurants.isEmpty()) {
//
//                StringBuilder stringBuilder = new StringBuilder();
//                stringBuilder.append("The Restaurants are who Give Service to Location  "+location+":\n");
//                for (Restaurant restaurant : allRestaurants) {
//                    String restaurantName = restaurant.getRestaurantName();
//                    stringBuilder.append(restaurantName).append("\n");
//                }
//                return stringBuilder;
//            }else {
//                StringBuilder stringBuilder=new StringBuilder();
//                stringBuilder.append("No Restaurant Give Service to ' "+location+" ' Location.");
//                return stringBuilder;
//            }
//
//        }catch (Exception e){
//            e.printStackTrace();
//            StringBuilder sb=new StringBuilder();
//            return sb.append("Sorry,Internal server Error,Please Contact To Admin.");
//        }
//
//    }//end of Retrieve  all Restaurant Based on Location

    //==========================================================================================
    //To Retrieve Restaurants based on the Service availability to a particular location
//    @Override
//    public StringBuilder getAllRestaurantsBasedOnParticularLocation(String location) {
//        StringBuilder stringBuilder=new StringBuilder();
//        try{
//            List<Integer> allRestaurantId = restaurantServiceRepositery.getAllRestaurantsBasedOnParticularLocation(location);
//            stringBuilder.append("Restaurants , Provide Service to the Location ' "+location+" ' are:\n" ).append("=====================================================================\n");
//           if(!allRestaurantId.isEmpty()){
//               for(Integer i: allRestaurantId){
//                   Optional<Restaurant> byId = restaurantRepositery.findById(i);
//                   if(byId.isPresent()){
//                       Restaurant restaurant = byId.get();
//                       String restaurantName = restaurant.getRestaurantName();
//                       stringBuilder.append(restaurantName).append("\n");
//
//                   }else{
//                       StringBuilder sb=new StringBuilder();
//                       return sb.append("Id Not Present");
//                   }
//               }
//               return stringBuilder;
//           }else{
//               StringBuilder sb=new StringBuilder();
//               return sb.append("No Restaurant Give Service to that  Location.");
//           }
//
//        }catch (Exception e){
//            e.printStackTrace();
//            StringBuilder sb=new StringBuilder();
//            return sb.append("Sorry,Internal server Error,Please Contact To Admin.");
//        }
//
//    }//end of Retrieve  all Restaurant Based on Location
    //==========================================================================================
    //To Retrieve Restaurants based on the Service availability to a particular location
    @Override
    public List<RestaurantDto> getAllRestaurantsBasedOnParticularLocation(String location) {
        List<RestaurantDto> restaurantDtoList=new ArrayList<>();
        try{
            List<Integer> allRestaurantId = restaurantServiceRepositery.getAllRestaurantsBasedOnParticularLocation(location);
            if(!allRestaurantId.isEmpty()){
                for(Integer i: allRestaurantId){
                    Optional<Restaurant> byId = restaurantRepositery.findById(i);
                    if(byId.isPresent()){
                        Restaurant restaurant = byId.get();
                        RestaurantDto restaurantDto=new RestaurantDto(restaurant.getRestaurantId(),restaurant.getRestaurantName(),restaurant.getRestaurantLocation());
                        restaurantDtoList.add(restaurantDto);
                    }
                }

            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return restaurantDtoList;
    }//end of Retrieve  all Restaurant Based on Location
    //=======================================================================================================
}
