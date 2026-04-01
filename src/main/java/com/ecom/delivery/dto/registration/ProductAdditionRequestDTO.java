package com.ecom.delivery.dto.registration;

import com.ecom.delivery.entity.enums.ProductCategory;
import com.ecom.delivery.entity.enums.ProductType;
import com.ecom.delivery.entity.enums.Weight;

public record ProductAdditionRequestDTO(String name,
                                        String description,
                                        ProductType productType,
                                        ProductCategory productCategory,
                                        Weight weight,
                                        Long vendorId) {
}
