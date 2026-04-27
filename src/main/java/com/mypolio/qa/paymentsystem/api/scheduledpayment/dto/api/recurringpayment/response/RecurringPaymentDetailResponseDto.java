package com.mypolio.qa.paymentsystem.api.scheduledpayment.dto.api.recurringpayment.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RecurringPaymentDetailResponseDto {
    private PaymentsRequestDataDto paymentsRequest;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class PaymentsRequestDataDto {
        private RecurringPaymentDetailDataDto data;
        private Map<String, String> links;
        private Map<String, Object> meta;
    }
}

