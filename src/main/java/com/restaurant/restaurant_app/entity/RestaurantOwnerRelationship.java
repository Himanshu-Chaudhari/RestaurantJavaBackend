package com.restaurant.restaurant_app.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "restaurantOwnerRelationship")
@Data
public class RestaurantOwnerRelationship {
    
    @Id
    @Column(name = "restaurantOwnerRelationshipId")
    private int restaurantOwnerRelationshipId;

    @ManyToOne
    @JoinColumn(name = "restaurantId")
    private Restaurant restaurantId;

    @ManyToOne
    @JoinColumn(name = "restaurantOwnerId")
    private RestaurantOwner restaurantOwnerId;
    
}
