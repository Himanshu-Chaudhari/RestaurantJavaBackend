package com.restaurant.restaurant_app.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class RegisterRestaurantRequest {
    private String name;
    private Long mobile;
    private String address;
    private String city;
    private String state;
}
