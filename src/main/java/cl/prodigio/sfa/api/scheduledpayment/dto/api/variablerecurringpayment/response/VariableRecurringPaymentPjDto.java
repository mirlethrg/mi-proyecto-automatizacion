package cl.prodigio.sfa.api.scheduledpayment.dto.api.variablerecurringpayment.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class VariableRecurringPaymentPjDto extends VariableRecurringPaymentBaseDto {
    private String paymentStatus;
    private String debtorRepresentativeId;
    private String debtorRepresentativeRole;
}
