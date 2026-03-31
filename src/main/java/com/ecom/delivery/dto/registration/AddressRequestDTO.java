package com.ecom.delivery.dto.registration;

import jakarta.validation.constraints.NotNull;

public record AddressRequestDTO(String district,
                                String state,
                                @NotNull Integer pincode) {
}
