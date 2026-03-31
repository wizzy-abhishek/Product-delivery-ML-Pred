package com.ecom.delivery.dto.registration;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record VendorRegistrationDTO(@NotBlank
                                    @Pattern(regexp = "^[0-9]{2}[A-Z]{5}[0-9]{4}[A-Z]{1}[1-9A-Z]{1}Z[0-9A-Z]{1}$")
                                    String gstNumber,
                                    String name,
                                    @NotNull
                                    AddressDTO addressDTO) {
}
