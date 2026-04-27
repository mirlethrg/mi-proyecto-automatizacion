package com.mypolio.qa.paymentsystem.api.scheduledpayment.dto.api.variablerecurringpayment.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VariablePaymentRequestPnDto {
    private VariablePaymentRequestDataPnDto paymentsRequest;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class VariablePaymentRequestDataPnDto {
        private VariablePaymentDataPnDto data;
        private Map<String, String> links;
        private Map<String, Object> meta;
    }
}

