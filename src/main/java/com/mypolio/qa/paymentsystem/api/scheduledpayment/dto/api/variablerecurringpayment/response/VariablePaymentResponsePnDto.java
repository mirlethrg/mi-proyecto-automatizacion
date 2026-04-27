package com.mypolio.qa.paymentsystem.api.scheduledpayment.dto.api.variablerecurringpayment.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VariablePaymentResponsePnDto {
    private VariablePaymentResponseDataPnDto paymentsResponse;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class VariablePaymentResponseDataPnDto {
        private VariablePaymentsDataPnDto data;
        private Map<String, String> links;
        private Map<String, Object> meta;
    }
}

