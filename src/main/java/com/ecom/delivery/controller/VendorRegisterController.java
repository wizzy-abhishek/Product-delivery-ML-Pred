package com.ecom.delivery.controller;

import com.ecom.delivery.dto.registration.VendorRegistrationDTO;
import com.ecom.delivery.service.VendorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/vendor")
public class VendorRegisterController {

    private final VendorService vendorService;

    @PostMapping()
    public ResponseEntity<String> registerVendor(@Valid @RequestBody VendorRegistrationDTO vendorDataDTO){
        return ResponseEntity.ok(vendorService.addVendor(vendorDataDTO));
    }
}
