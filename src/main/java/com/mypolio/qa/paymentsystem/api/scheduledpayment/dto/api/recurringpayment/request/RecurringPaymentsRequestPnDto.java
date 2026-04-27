package com.mypolio.qa.paymentsystem.api.scheduledpayment.dto.api.recurringpayment.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RecurringPaymentsRequestPnDto {
    private RecurringPaymentsRequestDataPnDto paymentsRequest;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RecurringPaymentsRequestDataPnDto {
        private RecurringPaymentsDataPnDto data;
        private Map<String, String> links;
        private Map<String, Object> meta;
    }
}

