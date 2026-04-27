package com.mypolio.qa.paymentsystem.api.scheduledpayment.dto.api.recurringpayment.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RecurringPaymentsDataPjDto {
    private List<RecurringPaymentPjDto> payments;
}

