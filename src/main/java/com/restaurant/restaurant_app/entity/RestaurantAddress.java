package com.restaurant.restaurant_app.entity;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "restaurantAddress")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @OneToMany(mappedBy = "addressId", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RestaurantContact> contacts;

    @OneToMany(mappedBy = "addressId", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RestaurantLegalDocuments> legalDocuments;


}