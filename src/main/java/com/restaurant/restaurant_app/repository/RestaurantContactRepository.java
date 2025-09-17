package com.restaurant.restaurant_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restaurant.restaurant_app.entity.RestaurantContact;

@Repository
public interface RestaurantContactRepository extends JpaRepository<RestaurantContact,Integer>{
    
}
