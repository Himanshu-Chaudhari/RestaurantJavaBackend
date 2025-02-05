package com.restaurant.restaurant_app.service.implementations;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.restaurant.restaurant_app.entity.Restaurant;
import com.restaurant.restaurant_app.entity.RestaurantAddress;
import com.restaurant.restaurant_app.entity.RestaurantContact;
import com.restaurant.restaurant_app.entity.RestaurantLegalDocuments;
import com.restaurant.restaurant_app.models.RegisterRestaurantRequest;
import com.restaurant.restaurant_app.models.RestaurantsResponse;
import com.restaurant.restaurant_app.repository.RestaurantRepository;
import com.restaurant.restaurant_app.service.RestaurantServices;

@Service
public class RestaurantServicesImplementations implements RestaurantServices {
    
    private final RestaurantRepository restaurantRepository;

    public RestaurantServicesImplementations(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    private Restaurant mapDTOToEntity(RegisterRestaurantRequest registerRestaurantRequest){

        Restaurant restaurant = Restaurant.builder()
        .restaurantId(null)
        .restaurantName(registerRestaurantRequest.getRestaurantName())
        .mobileNo(registerRestaurantRequest.getMobileNo())
        .restaurantType(
            "Veg".equalsIgnoreCase(registerRestaurantRequest.getRestroType()) 
            ? Restaurant.RestroType.Veg 
            : Restaurant.RestroType.NonVeg )
        .speciality(registerRestaurantRequest.getSpeciality())
        .closingHours(registerRestaurantRequest.getClossingHour())
        .openingHours(registerRestaurantRequest.getClossingHour())
        .logo(registerRestaurantRequest.getLogo())
        .serviceType(registerRestaurantRequest.getServiceType()).build();

        RestaurantAddress restaurantAddress = RestaurantAddress.builder()
            .addressLine1(registerRestaurantRequest.getAddressLine1())
            .addressLine2(registerRestaurantRequest.getAddressLine2())
            .city(registerRestaurantRequest.getCity())
            .state(registerRestaurantRequest.getState())
            .country(registerRestaurantRequest.getCountry())
            .restaurant(restaurant)
            .pincode(registerRestaurantRequest.getPincode()).build();
        
        RestaurantContact restaurantContact = RestaurantContact.builder()
            .addressId(restaurantAddress)
            .mobileNo(registerRestaurantRequest.getMobileNo())
            .email(registerRestaurantRequest.getEmail()).build();

        RestaurantLegalDocuments restaurantLegalDocuments = RestaurantLegalDocuments.builder()
            .addressId(restaurantAddress)
            .foodLicence(registerRestaurantRequest.getFoodLicense())
            .build();
        
            restaurantAddress.setContacts(List.of(restaurantContact));
            restaurantAddress.setLegalDocuments(List.of(restaurantLegalDocuments));
            restaurant.setBaseAddress(List.of(restaurantAddress));

            return restaurant;
    }

    @Override
    public boolean registerRestaurant(RegisterRestaurantRequest registerRestaurantRequest){
        Restaurant restaurant = mapDTOToEntity(registerRestaurantRequest);
        Restaurant persistedData = restaurantRepository.save(restaurant);

        if(ObjectUtils.isEmpty(persistedData)){
            return false;
        }
        return true;
    }

    public List<RestaurantsResponse> mapEnityToDTO(List<Restaurant> restaurants) {
        List<RestaurantsResponse> restaurantResponseList = new ArrayList<>();
    
        for (Restaurant restaurant : restaurants) {
            // Get the first address if available
            RestaurantAddress address = null;
            if (restaurant.getBaseAddress() != null && !restaurant.getBaseAddress().isEmpty()) {
                address = restaurant.getBaseAddress().get(0);
            }
    
            // Extract address details
            String addressLine1 = address != null ? address.getAddressLine1() : "N/A";
            String addressLine2 = address != null ? address.getAddressLine2() : "N/A";
            String city = address != null ? address.getCity() : "N/A";
            String state = address != null ? address.getState() : "N/A";
            String country = address != null ? address.getCountry() : "N/A";
            String pincode = address != null ? address.getPincode() : "N/A";
    
            // Extract contact details from the first address
            List<RestaurantContact> contacts = address != null ? address.getContacts() : null;
            String mobileNo = "N/A";
            String email = "N/A";
            if (contacts != null && !contacts.isEmpty()) {
                RestaurantContact contact = contacts.get(0); // Get the first contact
                mobileNo = contact.getMobileNo() ;
                email = contact.getEmail();
            }
    
            // Extract legal document details from the first address
            List<RestaurantLegalDocuments> legalDocuments = address != null ? address.getLegalDocuments() : null;
            String legalDocumentDetails = "N/A";
            if (legalDocuments != null && !legalDocuments.isEmpty()) {
                RestaurantLegalDocuments doc = legalDocuments.get(0); // Get the first legal document
                legalDocumentDetails = doc.getFoodLicence() != null ? doc.getFoodLicence() : "N/A";
            }
    
            // Build the response
            restaurantResponseList.add(RestaurantsResponse.builder()
                .restaurantName(restaurant.getRestaurantName())
                .mobileNo(mobileNo)
                .email(email)
                .addressLine1(addressLine1)
                .addressLine2(addressLine2)
                .city(city)
                .state(state)
                .country(country)
                .pincode(pincode)
                .restroType(restaurant.getRestaurantType().name())
                .speciality(restaurant.getSpeciality())
                .foodLicense(legalDocumentDetails)
                .serviceType(restaurant.getServiceType())
                .openingHour(restaurant.getOpeningHours())
                .clossingHour(restaurant.getClosingHours())
                .logo(restaurant.getLogo())
                .build()
            );
        }
    
        return restaurantResponseList;
    }
    
    
    @Override
    public List<RestaurantsResponse> getAllRestaurants() {
        List<Restaurant> restaurantDetails = restaurantRepository.findAll();
        return mapEnityToDTO(restaurantDetails);
    }
    
}
