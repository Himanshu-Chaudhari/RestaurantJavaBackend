package com.restaurant.restaurant_app.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "restaurantOwnerRelationship")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantOwnerRelationship {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "restaurantOwnerRelationshipId")
    private int restaurantOwnerRelationshipId;

    @ManyToOne
    @JoinColumn(name = "restaurantId")
    private Restaurant restaurantId;

    @ManyToOne
    @JoinColumn(name = "restaurantOwnerId")
    private RestaurantOwner restaurantOwnerId;
    
}
