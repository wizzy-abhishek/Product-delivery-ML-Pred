package com.ecom.delivery.service.impl;

import com.ecom.delivery.dto.registration.ProductAdditionRequestDTO;
import com.ecom.delivery.dto.response.ProductResponseDTO;
import com.ecom.delivery.entity.Product;
import com.ecom.delivery.entity.Vendor;
import com.ecom.delivery.repo.ProductRepo;
import com.ecom.delivery.repo.VendorRepo;
import com.ecom.delivery.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepo productRepo;
    private final VendorRepo vendorRepo;
    private final DeliveryPredictionService deliveryPredictionService;

    @Override
    public String addProduct(ProductAdditionRequestDTO productDTO) {
        Vendor vendor = vendorRepo.findById(productDTO.vendorId())
                .orElseThrow();

        var product = productRepo.save(new Product(productDTO.name(),
                productDTO.description(),
                productDTO.productType(),
                productDTO.productCategory(),
                vendor,
                productDTO.weight()));

        return product.getName();
    }

    @Override
    public ProductResponseDTO getProduct(Long productId, int userPincode) {
        Product product = productRepo.findById(productId).orElseThrow();
        var vendorPin = product.getVendor().getAddress().getPincode()/ 10000;
        userPincode /= 10000;

        var deliveryDetails = deliveryPredictionService.predict(vendorPin,  userPincode,
                product.getProductType().toString(), product.getWeight().toString().replaceAll("_", " "));
        return new ProductResponseDTO(product.getName(),
                product.getDescription(),
                deliveryDetails.toString()) ;
    }
}
