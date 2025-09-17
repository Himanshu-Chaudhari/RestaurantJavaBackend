package com.restaurant.restaurant_app.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "restaurantOwner")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantOwner {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ownerId")
    private Integer ownerId;

    @Column(name = "firstName", length = 50, nullable = true)
    private String firstName;

    @Column(name = "secondName", length = 50, nullable = true)
    private String secondName;

    @Column(name = "lastName", length = 50, nullable = true)
    private String lastName;
 
    @Column(name = "countryCode", length = 3, nullable = true)
    private String countryCode;

    @Column(name = "mobileNo", length = 20, nullable = true , unique = true)
    private String mobileNo;

    @Column(name = "email", length = 40, nullable = true , unique = true)
    private String email;

    public enum GovernmentIdType{
        panCard,adharCard
    }

    @Enumerated
    @Column(name = "governmentIdType", nullable = true)
    private GovernmentIdType governmentIdType;

    @Column(name = "governmentId", length = 20, nullable = true)
    private String governmentId;

    @Column(name = "password", length = 20, nullable = true)
    private String password;

}

