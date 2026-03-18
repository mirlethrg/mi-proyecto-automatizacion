package cl.prodigio.sfa.api.scheduledpayment.dto.api.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StatusReasonDto {
    private String code;
    private String description;
    private String category;
}
