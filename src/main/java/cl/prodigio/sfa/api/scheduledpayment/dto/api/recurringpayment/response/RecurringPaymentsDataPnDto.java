package cl.prodigio.sfa.api.scheduledpayment.dto.api.recurringpayment.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RecurringPaymentsDataPnDto {
    private List<RecurringPaymentPnDto> payments;
}
