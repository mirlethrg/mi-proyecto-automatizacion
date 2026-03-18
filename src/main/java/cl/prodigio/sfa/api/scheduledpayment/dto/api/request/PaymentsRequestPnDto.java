package cl.prodigio.sfa.api.scheduledpayment.dto.api.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentsRequestPnDto {
    private PaymentsRequestDataPnDto paymentsRequest;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class PaymentsRequestDataPnDto {
        private PaymentsDataPnDto data;
        private Map<String, String> links;
        private Map<String, Object> meta;
    }
}
