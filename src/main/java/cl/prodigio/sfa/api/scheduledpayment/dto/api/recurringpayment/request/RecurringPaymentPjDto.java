package cl.prodigio.sfa.api.scheduledpayment.dto.api.recurringpayment.request;

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
public class RecurringPaymentPjDto extends RecurringPaymentBaseDto {
    private String debtorRepresentativeId;
    private String debtorRepresentativeRole;
}
