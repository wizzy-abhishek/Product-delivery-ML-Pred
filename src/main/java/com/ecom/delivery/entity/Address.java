package com.ecom.delivery.entity;

import jakarta.persistence.*;

@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String district;

    @Column(nullable = false)
    private String state;

    @Column(nullable = false)
    private Long pincode;
}
