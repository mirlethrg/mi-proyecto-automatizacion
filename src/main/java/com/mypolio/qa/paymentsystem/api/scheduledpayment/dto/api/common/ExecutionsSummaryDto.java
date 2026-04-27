package com.mypolio.qa.paymentsystem.api.scheduledpayment.dto.api.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExecutionsSummaryDto {
    private Integer totalScheduled;
    private Integer totalExecuted;
    private Integer totalFailed;
}

