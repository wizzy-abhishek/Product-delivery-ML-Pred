package com.ecom.delivery.dto.registration;

import jakarta.validation.constraints.NotBlank;

public record VendorRequestDTO(@NotBlank String gstNumber,
                               String name) {
}
