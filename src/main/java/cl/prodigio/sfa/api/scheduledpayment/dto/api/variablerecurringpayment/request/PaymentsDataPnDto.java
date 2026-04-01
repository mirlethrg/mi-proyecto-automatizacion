package cl.prodigio.sfa.api.scheduledpayment.dto.api.variablerecurringpayment.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentsDataPnDto {
    private List<VariableRecurringPaymentPnDto> payments;
}
