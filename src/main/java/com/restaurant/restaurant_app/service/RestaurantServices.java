package com.restaurant.restaurant_app.service;

import java.util.List;

import com.restaurant.restaurant_app.models.RegisterRestaurantRequest;
import com.restaurant.restaurant_app.models.RestaurantsResponse;

public interface RestaurantServices {
    public boolean registerRestaurant(RegisterRestaurantRequest registerRestaurantRequest);

    public List<RestaurantsResponse> getAllRestaurants();
}

