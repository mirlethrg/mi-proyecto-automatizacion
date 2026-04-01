package cl.prodigio.sfa.api.scheduledpayment.dto.api.variablerecurringpayment.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LimitsResponseDto {
    private Integer maxOccurrences;
    private Integer occurrencesRemaining;
    private Double totalAmountLimit;
    private Double totalAmountUsed;
}
