package com.ecom.delivery.service.impl;

import com.ecom.delivery.dto.response.DeliveryPredictionResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class DeliveryPredictionService {

    private final RestTemplate restTemplate = new RestTemplate();

    @Value("${ml_model}")
    private String ML_MODEL_API;

    public DeliveryPredictionResponse predict(int pickupPrefix, int deliveryPrefix,
                                              String category, String weightBucket) {
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("pickup_prefix",    pickupPrefix);
        requestBody.put("delivery_prefix",  deliveryPrefix);
        requestBody.put("product_category", category);
        requestBody.put("weight_bucket",    weightBucket);

        return restTemplate.postForObject(ML_MODEL_API, requestBody, DeliveryPredictionResponse.class);
    }
}
