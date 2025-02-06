package com.restaurant.restaurant_app.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restaurant.restaurant_app.models.AddOwnerToRestaurant;
import com.restaurant.restaurant_app.models.RegisterRestaurantRequest;
import com.restaurant.restaurant_app.models.RestaurantsResponse;
import com.restaurant.restaurant_app.service.implementations.RestaurantServicesImplementations;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/restaurant")
public class Restaurant {

    private final RestaurantServicesImplementations restaurantService;
    Restaurant(final RestaurantServicesImplementations restaurantService){
        this.restaurantService = restaurantService;
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllRestaurants() {
        try {
            List<RestaurantsResponse> restaurants = this.restaurantService.getAllRestaurants();
            return new ResponseEntity<>(restaurants, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to fetch restaurants: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @PostMapping("/register")
    public ResponseEntity<String> registerRestaurant(@RequestBody RegisterRestaurantRequest registerRestaurantRequest) {
        try{
            this.restaurantService.registerRestaurant(registerRestaurantRequest);
            return new ResponseEntity<>("hello" , HttpStatus.OK);
        }catch(Error err){
            return new ResponseEntity<>( err.toString() , HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PostMapping("/addOwner")
    public boolean addOwnerToRestaurant(@RequestBody AddOwnerToRestaurant request) {
        boolean response = this.restaurantService.addOwnerToRestaurant(request.getRestaurantId(), request.getOwnerId());
        return response;
    }
    
    
}
