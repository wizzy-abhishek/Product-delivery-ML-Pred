package com.ecom.delivery.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record AddressDTO (String district,
                          String state,
                          @NotNull
                          @Size(min = 110001,
                                  max = 999999)
                          Integer pincode){
}
