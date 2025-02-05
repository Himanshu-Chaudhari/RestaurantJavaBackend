package com.restaurant.restaurant_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.restaurant.restaurant_app.entity.Restaurant;
public interface RestaurantRepository extends JpaRepository<Restaurant,Integer>{
    
}
