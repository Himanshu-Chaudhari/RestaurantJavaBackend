package com.restaurant.restaurant_app.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "restaurantlLegalDocuments")
@Data
public class RestaurantLegalDocuments {

    @Id
    @Column(name = "legalDocumentId")
    private Integer legalDocumentId;

    @ManyToOne
    @JoinColumn(name = "addressId")
    private RestaurantAddress addressId;

    @Column(name = "foodLicence",nullable = false,length = 200)
    private String foodLicence;
    
}
