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
@Table(name = "restaurantLegalDocuments")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantLegalDocuments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "legalDocumentId")
    private Integer legalDocumentId;

    @ManyToOne
    @JoinColumn(name = "addressId")
    private RestaurantAddress addressId;

    @Column(name = "foodLicence",nullable = false,length = 200)
    private String foodLicence;
    
}
