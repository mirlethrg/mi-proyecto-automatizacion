package cl.prodigio.sfa.api.scheduledpayment.dto.api.variablerecurringpayment.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LimitsRequestDto {
    private Double maxTotalAmount;
    private Integer maxOccurrences;
    private String expirationDate;
}
