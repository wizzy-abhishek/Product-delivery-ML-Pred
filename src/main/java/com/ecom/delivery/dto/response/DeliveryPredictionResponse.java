package com.ecom.delivery.dto.response;

import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class DeliveryPredictionResponse {

    private int predicted_day;
    private List<DayProbability> top_3_days;

    @Data
    public static class DayProbability {
        private String day;
        private Double probability;

        @Override
        public String toString() {
            return """
               {
                    day= %s, probability = %s
               }"""
                    .formatted(day, probability);
        }
    }

    @Override
    public String toString() {

        String formattedProbabilities = top_3_days == null ? "[]" :
                top_3_days.stream()
                        .map(DayProbability::toString)
                        .collect(Collectors.joining(",\n    ", "[\n    ", "\n]"));

        return """
           Expected delivery {predicted Day= %d,
           probabilities= %s}"""
                .formatted(predicted_day, formattedProbabilities);
    }
}