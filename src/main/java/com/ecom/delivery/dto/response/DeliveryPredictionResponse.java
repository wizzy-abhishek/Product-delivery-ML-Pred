package com.ecom.delivery.dto.response;

import lombok.Data;
import java.util.Map;

@Data
public class DeliveryPredictionResponse {

    private int predictedDay;
    private Map<String, Double> probabilities;

}
