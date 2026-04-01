package cl.prodigio.sfa.api.scheduledpayment.dto.api.recurringpayment.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentsResponsePjDto {
    private PaymentsResponseDataPjDto paymentsResponse;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class PaymentsResponseDataPjDto {
        private PaymentsDataPjDto data;
        private Map<String, String> links;
        private Map<String, Object> meta;
    }
}
