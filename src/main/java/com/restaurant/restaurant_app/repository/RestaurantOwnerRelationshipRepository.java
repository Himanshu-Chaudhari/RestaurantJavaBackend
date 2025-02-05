package com.restaurant.restaurant_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.restaurant.restaurant_app.entity.RestaurantOwnerRelationship;

public interface RestaurantOwnerRelationshipRepository extends JpaRepository<RestaurantOwnerRelationship,Integer> {
    
}
