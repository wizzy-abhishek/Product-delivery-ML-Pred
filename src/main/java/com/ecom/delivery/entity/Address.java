package com.ecom.delivery.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String district;

    @Column(nullable = false)
    private String state;

    @Column(nullable = false)
    private int pincode;

    public Address(String district, String state, int pincode) {
        this.district = district;
        this.state = state;
        this.pincode = pincode;
    }
}
