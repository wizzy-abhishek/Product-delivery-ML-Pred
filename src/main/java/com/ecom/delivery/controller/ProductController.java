package com.ecom.delivery.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    @GetMapping("/{productId}")
    public ResponseEntity<String> getProduct(@PathVariable String productId){
        return ResponseEntity.ok("");
    }
}
