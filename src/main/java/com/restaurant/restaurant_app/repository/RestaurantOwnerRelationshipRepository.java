package com.restaurant.restaurant_app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.restaurant.restaurant_app.entity.RestaurantOwnerRelationship;

public interface RestaurantOwnerRelationshipRepository extends JpaRepository<RestaurantOwnerRelationship,Integer> {
    List<RestaurantOwnerRelationship> findByRestaurantId_RestaurantId(Integer restaurantId);
}
