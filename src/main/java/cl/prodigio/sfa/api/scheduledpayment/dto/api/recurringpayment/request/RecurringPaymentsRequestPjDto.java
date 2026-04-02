package cl.prodigio.sfa.api.scheduledpayment.dto.api.recurringpayment.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RecurringPaymentsRequestPjDto {
    private RecurringPaymentsRequestDataPjDto paymentsRequest;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RecurringPaymentsRequestDataPjDto {
        private RecurringPaymentsDataPjDto data;
        private Map<String, String> links;
        private Map<String, Object> meta;
    }
}
