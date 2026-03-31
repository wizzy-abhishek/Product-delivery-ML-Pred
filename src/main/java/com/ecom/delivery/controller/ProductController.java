package com.ecom.delivery.controller;

import com.ecom.delivery.dto.response.ProductResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    @GetMapping("/{productId}")
    public ResponseEntity<ProductResponseDTO> getProduct(@PathVariable String productId){
        return ResponseEntity.ok(new ProductResponseDTO());
    }
}
