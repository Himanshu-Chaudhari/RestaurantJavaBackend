package com.restaurant.restaurant_app.service.implementations;

import org.springframework.stereotype.Service;

import com.restaurant.restaurant_app.models.RegisterRestaurantRequest;
import com.restaurant.restaurant_app.service.RegisterRestaurant;

@Service
public class RegisterRestaurantImplementations implements RegisterRestaurant {
    
    @Override
    public boolean registerRestaurant(RegisterRestaurantRequest registerRestaurantRequest){
        return false;
    }
}
