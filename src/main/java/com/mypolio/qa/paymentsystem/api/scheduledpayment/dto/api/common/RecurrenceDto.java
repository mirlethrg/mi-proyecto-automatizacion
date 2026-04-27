package com.mypolio.qa.paymentsystem.api.scheduledpayment.dto.api.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RecurrenceDto {
    private String frequency;
    private Integer interval;
    private Integer dayOfMonth;
}

