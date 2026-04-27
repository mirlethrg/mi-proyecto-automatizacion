package com.mypolio.qa.paymentsystem.api.scheduledpayment.dto.api.variablerecurringpayment.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VariablePaymentsDataPjDto {
    private List<VariableRecurringPaymentPjDto> payments;
}

