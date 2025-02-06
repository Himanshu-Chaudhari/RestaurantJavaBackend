package com.restaurant.restaurant_app.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restaurant.restaurant_app.models.GetOwnerResponse;
import com.restaurant.restaurant_app.models.RegisterOwnerRequest;
import com.restaurant.restaurant_app.service.implementations.RestaurantOwnerServicesImplementation;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController()
@RequestMapping("/owner")
public class Owner {
    private final RestaurantOwnerServicesImplementation restaurantOwnerServicesImplementation;
    Owner(RestaurantOwnerServicesImplementation restaurantOwnerServicesImplementation){
        this.restaurantOwnerServicesImplementation = restaurantOwnerServicesImplementation;
    }

    @PostMapping("/registerOwner")
    public boolean postMethodName(@RequestBody RegisterOwnerRequest entity) {
        boolean response = restaurantOwnerServicesImplementation.registerOwner(entity);
        return response;
    }

    @GetMapping("/getAllOwners")
    public List<GetOwnerResponse> getAllQwners() {
        return restaurantOwnerServicesImplementation.getAllOwner();
    }

    @GetMapping("/getOwnerDetails")
    public GetOwnerResponse getOwner(@RequestParam String param) {
        return restaurantOwnerServicesImplementation.getOwner(param);
    }

}
