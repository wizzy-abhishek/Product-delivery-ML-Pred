package com.ecom.delivery.service.impl;

import com.ecom.delivery.dto.request.ProductAdditionRequestDTO;
import com.ecom.delivery.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {


    @Override
    public String addProduct(ProductAdditionRequestDTO productAdditionRequestDTO) {
        return "";
    }
}
