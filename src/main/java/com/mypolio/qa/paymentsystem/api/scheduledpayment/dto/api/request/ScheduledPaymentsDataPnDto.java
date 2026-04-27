package com.mypolio.qa.paymentsystem.api.scheduledpayment.dto.api.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ScheduledPaymentsDataPnDto {
    private List<ScheduledPaymentPnDto> payments;
}

