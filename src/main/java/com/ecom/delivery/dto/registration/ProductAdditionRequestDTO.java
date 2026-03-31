package com.ecom.delivery.dto.registration;

import com.ecom.delivery.entity.enums.ProductCategory;
import com.ecom.delivery.entity.enums.ProductType;

public record ProductAdditionRequestDTO(String name,
                                        String description,
                                        ProductType productType,
                                        ProductCategory productCategory,
                                        Long vendorId) {
}
