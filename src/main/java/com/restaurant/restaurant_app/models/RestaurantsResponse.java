package com.restaurant.restaurant_app.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RestaurantsResponse {
    private String restaurantName;
    private String mobileNo;
    private String email;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private String country;
    private String pincode;
    private String restroType;
    private String speciality;
    private String foodLicense;
    private String serviceType;
    private String openingHour;
    private String clossingHour;
    private String logo; 
}
