package com.ecom.delivery.controller;

import com.ecom.delivery.dto.request.VendorRegistrationDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vendor")
public class VendorRegisterController {


    @PostMapping()
    public ResponseEntity<String> registerVendor(@RequestBody VendorRegistrationDTO vendorDataDTO){
        return ResponseEntity.ok("");
    }
}
