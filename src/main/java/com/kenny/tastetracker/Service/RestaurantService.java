package com.kenny.tastetracker.Service;

import com.kenny.tastetracker.Entity.Restaurant;
import com.kenny.tastetracker.Repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;
    private final double MILES = 1.0;

    @Autowired
    public RestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    public List <Restaurant> getRestaurantsByLocation(double latitude, double longitude) throws InvalidLocationException{
        validateLocation(latitude, longitude);
        double[] locationRanges = calculateLocationRange(latitude, longitude);
        List<Restaurant> allRestaurants;
        allRestaurants = restaurantRepository.findRestaurantByLocation(locationRanges[0], locationRanges[1], locationRanges[2], locationRanges[3]);
        for (Restaurant r : allRestaurants) {
            r.setDistanceFromUser(latitude, longitude);
            r.setWalkingTime(latitude, longitude);
        }
        return allRestaurants;
    }

    public Restaurant getRestaurantByID(long id) {
        return restaurantRepository.findRestaurantsById(id);
    }

    public class InvalidLocationException extends Exception {
        public InvalidLocationException(String message) {
            super(message);
        }
    }

    public void validateLocation(double latitude, double longitude) throws InvalidLocationException {
        if (latitude < -90 || latitude > 90) {
            throw new InvalidLocationException("Invalid latitude.");
        } else if (longitude < -180 || longitude > 180) {
            throw new InvalidLocationException("Invalid longitude");
        }
    }

    public double[] calculateLocationRange (double latitude, double longitude) {
        double angularDistance = MILES/60.0;
        double latitudeMax = latitude + angularDistance;
        double latitudeMin = latitude - angularDistance;
        double longitudeDistance = (angularDistance / Math.cos(Math.toRadians(latitude))) * 180.0 / Math.PI;
        double longitudeMax = longitude + longitudeDistance;
        double longitudeMin = longitude - longitudeDistance;
        return new double[]{latitudeMin, latitudeMax, longitudeMin, longitudeMax};
    }
}
