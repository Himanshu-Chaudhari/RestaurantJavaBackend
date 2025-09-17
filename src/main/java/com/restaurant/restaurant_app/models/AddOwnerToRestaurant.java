package com.restaurant.restaurant_app.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class AddOwnerToRestaurant {
    private String restaurantId;
    private String ownerId;
}
