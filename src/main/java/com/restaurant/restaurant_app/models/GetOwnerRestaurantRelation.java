package com.restaurant.restaurant_app.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetOwnerRestaurantRelation {
    private Integer restaurantId ;
    private Integer restaurantOwnerId;
}
