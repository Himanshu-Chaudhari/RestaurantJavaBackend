package com.restaurant.restaurant_app.service;
import java.util.List;
import com.restaurant.restaurant_app.models.GetOwnerResponse;
import com.restaurant.restaurant_app.models.RegisterOwnerRequest;

public interface RestaurantOwnerServices {
    public boolean registerOwner(RegisterOwnerRequest registerOwnerRequest);
    public List<GetOwnerResponse> getAllOwner();
    public GetOwnerResponse getOwner(String ownerId);
}
