package cl.prodigio.sfa.api.scheduledpayment.dto.api.variablerecurringpayment.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentsResponsePnDto {
    private PaymentsResponseDataPnDto paymentsResponse;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class PaymentsResponseDataPnDto {
        private PaymentsDataPnDto data;
        private Map<String, String> links;
        private Map<String, Object> meta;
    }
}
