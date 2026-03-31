package com.ecom.delivery.controller;

import com.ecom.delivery.dto.registration.ProductAdditionRequestDTO;
import com.ecom.delivery.dto.response.ProductResponseDTO;
import com.ecom.delivery.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/{productId}")
    public ResponseEntity<ProductResponseDTO> getProduct(@PathVariable Long productId){
        return ResponseEntity.ok(productService.getProduct(productId));
    }

    @PostMapping()
    public ResponseEntity<String> addProduct(@Valid @RequestBody ProductAdditionRequestDTO productDTO){
        return ResponseEntity.ok(productService.addProduct(productDTO));
    }
}
