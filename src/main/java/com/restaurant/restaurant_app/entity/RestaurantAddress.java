package com.restaurant.restaurant_app.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "restaurantAddress")
@Data
public class RestaurantAddress {

    @Id
    @Column(name = "addressId")
    private Integer addressId;

    @ManyToOne
    @JoinColumn(name="restroId", nullable = false)
    private Restaurant restaurant;

    @Column(name = "addressLine1", length = 200, nullable = false )
    private String addressLine1;

    @Column(name = "addressLine2", length = 200, nullable = true )
    private String addressLine2;

    @Column(name = "city", length = 50, nullable = false )
    private String city;

    @Column(name = "state", length = 50, nullable = false )
    private String state;

    @Column(name = "country", length = 50, nullable = false )
    private String country;

    @Column(name = "pincode", length = 10, nullable = false )
    private String pincode;


}