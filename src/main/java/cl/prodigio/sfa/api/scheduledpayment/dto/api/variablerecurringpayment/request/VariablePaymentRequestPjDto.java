package cl.prodigio.sfa.api.scheduledpayment.dto.api.variablerecurringpayment.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VariablePaymentRequestPjDto {
    private VariablePaymentRequestDataPjDto paymentsRequest;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class VariablePaymentRequestDataPjDto {
        private VariablePaymentDataPjDto data;
        private Map<String, String> links;
        private Map<String, Object> meta;
    }
}
