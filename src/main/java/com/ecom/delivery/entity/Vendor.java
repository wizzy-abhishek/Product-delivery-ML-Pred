package com.ecom.delivery.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Vendor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true,
            nullable = false)
    private String gstNumber;

    private String name;

    @OneToOne(optional = false,
            fetch = FetchType.LAZY)
    private Address address;

    public Vendor(String gstNumber, String name, Address address) {
        this.gstNumber = gstNumber;
        this.name = name;
        this.address = address;
    }
}
