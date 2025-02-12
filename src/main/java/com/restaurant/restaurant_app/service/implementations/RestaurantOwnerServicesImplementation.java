package com.restaurant.restaurant_app.service.implementations;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

import com.restaurant.restaurant_app.entity.RestaurantOwner;
import com.restaurant.restaurant_app.entity.RestaurantOwner.GovernmentIdType;
import com.restaurant.restaurant_app.models.GetOwnerResponse;
import com.restaurant.restaurant_app.models.RegisterOwnerRequest;
import com.restaurant.restaurant_app.repository.RestaurantOwnerRepository;
import com.restaurant.restaurant_app.service.RestaurantOwnerServices;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class RestaurantOwnerServicesImplementation implements RestaurantOwnerServices {
    private final RestaurantOwnerRepository restaurantOwnerRepository;

    RestaurantOwnerServicesImplementation(RestaurantOwnerRepository restaurantOwnerRepository){
        this.restaurantOwnerRepository = restaurantOwnerRepository;
    }
    
    private RestaurantOwner mapDTOToEntity(RegisterOwnerRequest registerOwnerRequest){
        RestaurantOwner restaurantOwner = RestaurantOwner.builder()
            .firstName(registerOwnerRequest.getFirstName())
            .secondName(registerOwnerRequest.getSecondName())
            .lastName(registerOwnerRequest.getLastName())
            .countryCode(registerOwnerRequest.getCountryCode())
            .mobileNo(registerOwnerRequest.getMobileNo())
            .email(registerOwnerRequest.getEmail())
            .governmentId(registerOwnerRequest.getGovernmentId())
            .governmentIdType(GovernmentIdType.valueOf(registerOwnerRequest.getGovernmentIdType()))
            .password(registerOwnerRequest.getPassword()).build();
        return restaurantOwner;
    }

    @Override
    public boolean registerOwner(RegisterOwnerRequest registerOwnerRequest){
        RestaurantOwner restaurantOwner = mapDTOToEntity(registerOwnerRequest);
        RestaurantOwner response = this.restaurantOwnerRepository.save(restaurantOwner);
        if(response.equals(null)){
            return false;
        }
        return true;
    }

    private List<GetOwnerResponse> mapEntityToDTO(List<RestaurantOwner> owners){
        List<GetOwnerResponse> ownerResponses = new ArrayList<GetOwnerResponse>();
        for(RestaurantOwner owner : owners){
            ownerResponses.add(GetOwnerResponse.builder()
                .firstName(owner.getFirstName())
                .secondName(owner.getSecondName())
                .lastName(owner.getLastName())
                .countryCode(owner.getCountryCode())
                .mobileNo(owner.getMobileNo())
                .governmentIdType(owner.getGovernmentIdType().toString())
                .governmentId(owner.getGovernmentId())
                .email(owner.getEmail())
                .ownerId(owner.getOwnerId()).build()
            );
        }
        log.info(ownerResponses.toString());
        return ownerResponses;
    }

    @Override
    public List<GetOwnerResponse> getAllOwner(){
        List<RestaurantOwner> owners = restaurantOwnerRepository.findAll();
        List<GetOwnerResponse> ownersList = mapEntityToDTO(owners);
        return ownersList;
    }

    private GetOwnerResponse mapEntityToResponse(RestaurantOwner owner) {
        return GetOwnerResponse.builder()
            .ownerId(owner.getOwnerId())
            .firstName(owner.getFirstName())
            .secondName(owner.getSecondName())
            .lastName(owner.getLastName())
            .countryCode(owner.getCountryCode())
            .mobileNo(owner.getMobileNo())
            .email(owner.getEmail())
            .governmentIdType(owner.getGovernmentIdType().name())
            .governmentId(owner.getGovernmentId())
            .build();
    }
    
    @Override
    public GetOwnerResponse getOwner(String ownerId){
        try {
            Integer id = Integer.parseInt(ownerId);
            return restaurantOwnerRepository.findById(id).map(this::mapEntityToResponse)
            .orElseThrow(() -> new IllegalArgumentException("Owner not found for ID: " + ownerId));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid owner ID: " + ownerId, e);
        }
    }
}
