package com.kenny.tastetracker.DTO.Mapper;

import com.kenny.tastetracker.DTO.RestaurantDTO;
import com.kenny.tastetracker.Entity.Restaurant;

public class RestaurantDTOMapper {
    public RestaurantDTO toDTO(Restaurant restaurant) {
        return new RestaurantDTO(
                restaurant.getId(),
                restaurant.getName(),
                restaurant.getAddress(),
                restaurant.getPhoneNumber(),
                restaurant.getLatitude(),
                restaurant.getLongitude(),
                restaurant.getRating(),
                restaurant.getCuisine().getName(),
                restaurant.getOperationHours(),
                restaurant.getMenuLink(),
                restaurant.getWebsiteLink(),
                restaurant.getAverageCostOfADish(),
                restaurant.getDistanceFromUser(),
                restaurant.getWalkingTime(),
                restaurant.getImageLink()
        );
    }
}
