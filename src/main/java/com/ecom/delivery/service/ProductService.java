package com.ecom.delivery.service;

import com.ecom.delivery.dto.registration.ProductAdditionRequestDTO;
import com.ecom.delivery.dto.response.ProductResponseDTO;

public interface ProductService {

    String addProduct(ProductAdditionRequestDTO productAdditionRequestDTO);
    ProductResponseDTO getProduct(Long productId, int userPincode);
}
