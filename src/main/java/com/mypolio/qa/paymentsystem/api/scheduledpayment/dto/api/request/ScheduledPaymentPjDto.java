package com.mypolio.qa.paymentsystem.api.scheduledpayment.dto.api.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ScheduledPaymentPjDto extends ScheduledPaymentBaseDto {
    @NotBlank(message = "debtorRepresentativeId cannot be null")
    private String debtorRepresentativeId;
    @NotBlank(message = "debtorRepresentativeRole cannot be null")
    private String debtorRepresentativeRole;
}

