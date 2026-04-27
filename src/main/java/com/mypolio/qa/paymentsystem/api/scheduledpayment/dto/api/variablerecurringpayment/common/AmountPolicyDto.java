package com.mypolio.qa.paymentsystem.api.scheduledpayment.dto.api.variablerecurringpayment.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AmountPolicyDto {
    private PerOccurrenceDto perOccurrence;
    private PeriodicCapsDto periodicCaps;
    private String currency;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class PerOccurrenceDto {
        private Double min;
        private Double max;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class PeriodicCapsDto {
        private Double daily;
        private Double monthly;
    }
}

