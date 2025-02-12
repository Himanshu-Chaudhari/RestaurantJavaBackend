package com.restaurant.restaurant_app.entity;

import java.util.List;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "restaurants")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "restaurantId")
    private Integer restaurantId;

    @Column(name = "restaurantName", length = 100, nullable = false)
    private String restaurantName;

    @Column(name = "mobileNo", length = 100, nullable = false , unique = true)
    private String mobileNo;

    public enum RestroType {
        Veg, NonVeg;
    }

    @Enumerated(EnumType.STRING) 
    @Column(name = "restaurantType", nullable = false)
    private RestroType restaurantType;

    @Column(name = "speciality", length = 200, nullable = true)
    private String speciality;

    @Column(name = "serviceType", length = 20, nullable = false)
    private String serviceType;

    @Column(name = "openingHours", length = 10, nullable = true)
    private String openingHours;

    @Column(name = "closingHours", length = 10, nullable = true)
    private String closingHours;

    @Column(name = "logo", length = 500, nullable = true)
    private String logo;

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    private List<RestaurantAddress> baseAddress;
}
