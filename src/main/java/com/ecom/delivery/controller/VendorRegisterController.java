package com.ecom.delivery.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vendor")
public class VendorRegisterController {


    @PostMapping()
    public ResponseEntity<String> registerVendor(){
        return ResponseEntity.ok("");
    }
}
