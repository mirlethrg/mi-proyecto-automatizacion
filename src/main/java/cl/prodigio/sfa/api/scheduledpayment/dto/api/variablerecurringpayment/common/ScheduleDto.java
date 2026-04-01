package cl.prodigio.sfa.api.scheduledpayment.dto.api.variablerecurringpayment.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.OffsetDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ScheduleDto {
    private LocalDate startDate;
    private OffsetDateTime firstExecutionDateTime;
    private LocalDate endDate;
    private Integer occurrences;
}
