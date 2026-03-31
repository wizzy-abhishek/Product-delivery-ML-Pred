package com.ecom.delivery.entity;

import com.ecom.delivery.entity.enums.ProductCategory;
import com.ecom.delivery.entity.enums.ProductType;
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

    private ProductType productType;

    private ProductCategory productCategory;

    @ManyToOne(fetch = FetchType.LAZY)
    private Vendor vendor;

    public Product(String name,
                   String description,
                   ProductType productType,
                   ProductCategory productCategory,
                   Vendor vendor) {
        this.name = name;
        this.description = description;
        this.productType = productType;
        this.productCategory = productCategory;
        this.vendor = vendor;
    }
}
