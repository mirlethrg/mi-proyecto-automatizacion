package cl.prodigio.sfa.api.scheduledpayment.dto.api.variablerecurringpayment.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentsDataPjDto {
    private List<VariableRecurringPaymentPjDto> payments;
}
