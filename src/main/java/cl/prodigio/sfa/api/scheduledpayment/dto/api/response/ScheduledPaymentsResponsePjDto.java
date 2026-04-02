package cl.prodigio.sfa.api.scheduledpayment.dto.api.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ScheduledPaymentsResponsePjDto {
    private ScheduledPaymentsResponseDataPjDto paymentsResponse;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ScheduledPaymentsResponseDataPjDto {
        private ScheduledPaymentsDataPjDto data;
        private Map<String, String> links;
        private Map<String, Object> meta;
    }
}
