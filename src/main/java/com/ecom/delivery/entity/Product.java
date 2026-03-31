package com.ecom.delivery.entity;

import com.ecom.delivery.entity.enums.ProductCategory;
import com.ecom.delivery.entity.enums.ProductType;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
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
}
