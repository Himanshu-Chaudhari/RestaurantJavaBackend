package com.restaurant.restaurant_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.restaurant.restaurant_app.entity.RestaurantOwner;

public interface RestaurantOwnerRepository extends JpaRepository<RestaurantOwner,Integer>{
    
}
