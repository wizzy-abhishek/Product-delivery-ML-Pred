package com.ecom.delivery.entity;

import com.ecom.delivery.entity.enums.ProductCategory;
import com.ecom.delivery.entity.enums.ProductType;
import com.ecom.delivery.entity.enums.Weight;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Enumerated(EnumType.STRING)
    private ProductType productType;

    @Enumerated(EnumType.STRING)
    private ProductCategory productCategory;

    @ManyToOne(fetch = FetchType.LAZY)
    private Vendor vendor;

    @Enumerated(EnumType.STRING)
    private Weight weight;

    public Product(String name,
                   String description,
                   ProductType productType,
                   ProductCategory productCategory,
                   Vendor vendor,
                   Weight weight) {
        this.name = name;
        this.description = description;
        this.productType = productType;
        this.productCategory = productCategory;
        this.vendor = vendor;
        this.weight = weight;
    }
}
