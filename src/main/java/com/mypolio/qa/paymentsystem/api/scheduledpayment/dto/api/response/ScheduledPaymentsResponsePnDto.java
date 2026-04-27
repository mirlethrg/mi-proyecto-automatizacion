package com.mypolio.qa.paymentsystem.api.scheduledpayment.dto.api.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ScheduledPaymentsResponsePnDto {
    private ScheduledPaymentsResponseDataPnDto paymentsResponse;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ScheduledPaymentsResponseDataPnDto {
        private ScheduledPaymentsDataPnDto data;
        private Map<String, String> links;
        private Map<String, Object> meta;
    }
}

