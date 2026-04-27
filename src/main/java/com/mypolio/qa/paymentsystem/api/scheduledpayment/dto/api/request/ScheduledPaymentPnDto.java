package com.mypolio.qa.paymentsystem.api.scheduledpayment.dto.api.request;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ScheduledPaymentPnDto extends ScheduledPaymentBaseDto {
}

