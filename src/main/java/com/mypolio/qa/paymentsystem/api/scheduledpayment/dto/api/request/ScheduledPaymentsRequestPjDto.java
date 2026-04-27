package com.mypolio.qa.paymentsystem.api.scheduledpayment.dto.api.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ScheduledPaymentsRequestPjDto {
    private ScheduledPaymentsRequestDataPjDto paymentsRequest;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ScheduledPaymentsRequestDataPjDto {
        private ScheduledPaymentsDataPjDto data;
        private Map<String, String> links;
        private Map<String, Object> meta;
    }
}

