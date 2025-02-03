package com.restaurant.restaurant_app.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "restaurantContact")
@Data
public class RestaurantContact {

    @Id
    @Column(name = "contactId")
    private Integer contactId;

    @ManyToOne
    @JoinColumn(name = "addressId",nullable = false)
    private RestaurantAddress addressId;

    @Column(name = "mobileNo",length = 20,nullable = false)
    private String mobileNo;

    @Column(name = "email",length = 50,nullable = false)
    private String email;
     
}