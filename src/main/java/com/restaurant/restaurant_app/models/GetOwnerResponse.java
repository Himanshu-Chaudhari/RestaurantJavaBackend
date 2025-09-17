package com.restaurant.restaurant_app.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetOwnerResponse {
    private Integer ownerId;
    private String firstName;
    private String secondName;
    private String lastName;
    private String countryCode;
    private String mobileNo;
    private String email;
    private String governmentIdType;
    private String governmentId;
    private String password;
}
