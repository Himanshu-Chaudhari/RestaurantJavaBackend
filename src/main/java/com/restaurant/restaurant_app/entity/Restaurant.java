package com.restaurant.restaurant_app.entity;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "restaurants")
@Data
public class Restaurant {

    @Id
    @Column(name = "restaurantId")
    private Integer addressId;

    @Column(name = "restaurantName", length = 100, nullable = false )
    private Integer restaurantName;

    public enum RestroType{
        Veg, Nonveg;
    }

    @Enumerated
    @Column(name = "restaurantType", nullable = false)
    private RestroType restaurantType;

    @Column(name = "speciality" , length = 200 , nullable = true)
    private String speciality;

    @Column(name = "serviceType", length = 20 ,nullable = false)
    private String serviceType;

    @Column(name = "openingHours", length = 10 ,nullable = true)
    private String openingHours;

    @Column(name = "closingHours", length = 10 ,nullable = true)
    private String closingHours;

    @OneToMany(mappedBy = "restaurant")
    private List<RestaurantAddress> baseAddress;

}