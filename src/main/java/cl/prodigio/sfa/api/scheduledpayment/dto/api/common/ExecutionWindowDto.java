package cl.prodigio.sfa.api.scheduledpayment.dto.api.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExecutionWindowDto {
    private OffsetDateTime from;
    private OffsetDateTime to;
}
