package com.restaurant.restaurant_app.service;

import java.util.*;

import com.restaurant.restaurant_app.models.GetOwnerRestaurantRelation;
import com.restaurant.restaurant_app.models.RegisterRestaurantRequest;
import com.restaurant.restaurant_app.models.RestaurantsResponse;

public interface RestaurantServices {
    public boolean registerRestaurant(RegisterRestaurantRequest registerRestaurantRequest);
    public List<RestaurantsResponse> getAllRestaurants();
    public boolean addOwnerToRestaurant(String restaurantId,String ownerId);
    public List<GetOwnerRestaurantRelation> getOwners(Integer restaurantId);
}

