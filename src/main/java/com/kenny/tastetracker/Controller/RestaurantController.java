package com.kenny.tastetracker.Controller;

import com.kenny.tastetracker.DTO.Mapper.RestaurantDTOMapper;
import com.kenny.tastetracker.DTO.RestaurantDTO;
import com.kenny.tastetracker.Entity.Restaurant;
import com.kenny.tastetracker.RequestBody.UserLocation;
import com.kenny.tastetracker.Service.RestaurantService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/tastetracker")
public class RestaurantController {
    private final RestaurantService restaurantService;
    private final RestaurantDTOMapper restaurantDTOMapper = new RestaurantDTOMapper();

    @Autowired
    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @PostMapping("/restaurants")
    public ResponseEntity<List<RestaurantDTO>> getAllRestaurants(@RequestBody UserLocation userLocation) throws RestaurantService.InvalidLocationException {
        if (userLocation == null) {
            throw new RuntimeException("Location cannot be empty");
        }
        List<Restaurant> restaurants = new ArrayList<>(restaurantService.getRestaurantsByLocation(userLocation.getLatitude(), userLocation.getLatitude()));
        List<RestaurantDTO> restaurantDTOList = new ArrayList<>();
        for (Restaurant r : restaurants) {
            restaurantDTOList.add(restaurantDTOMapper.toDTO(r));
        }
        return ResponseEntity.ok(restaurantDTOList);
    }

    @GetMapping("/restaurants/{id}")
    public ResponseEntity<RestaurantDTO> getRestaurantById(@PathVariable long id) {
        Restaurant restaurant = restaurantService.getRestaurantByID(id);
        RestaurantDTO restaurantDTO = restaurantDTOMapper.toDTO(restaurant);
        return ResponseEntity.ok(restaurantDTO);
    }
}
