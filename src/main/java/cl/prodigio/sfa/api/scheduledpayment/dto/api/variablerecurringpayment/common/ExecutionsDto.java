package cl.prodigio.sfa.api.scheduledpayment.dto.api.variablerecurringpayment.common;

import cl.prodigio.sfa.api.scheduledpayment.dto.api.common.ExecutionsSummaryDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExecutionsDto {
    private ExecutionsSummaryDto summary;
}
