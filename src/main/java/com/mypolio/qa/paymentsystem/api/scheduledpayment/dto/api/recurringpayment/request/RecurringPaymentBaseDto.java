package com.mypolio.qa.paymentsystem.api.scheduledpayment.dto.api.recurringpayment.request;

import com.mypolio.qa.paymentsystem.api.scheduledpayment.dto.api.common.ScheduleDto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public abstract class RecurringPaymentBaseDto {
    @NotBlank(message = "grantId cannot be null")
    private String grantId;
    @NotBlank(message = "transactionType cannot be null")
    private String transactionType;
    @NotBlank(message = "debtorInstitutionId cannot be null")
    private String debtorInstitutionId;
    @NotBlank(message = "debtorName cannot be null")
    private String debtorName;
    @NotBlank(message = "debtorIdentification cannot be null")
    private String debtorIdentification;
    @NotBlank(message = "debtorAccountType cannot be null")
    private String debtorAccountType;
    @NotBlank(message = "debtorAccountNumber cannot be null")
    private String debtorAccountNumber;
    @NotBlank(message = "creditorInstitutionId cannot be null")
    private String creditorInstitutionId;
    @NotBlank(message = "creditorName cannot be null")
    private String creditorName;
    @NotBlank(message = "creditorIdentification cannot be null")
    private String creditorIdentification;
    @NotBlank(message = "creditorAccountType cannot be null")
    private String creditorAccountType;
    @NotBlank(message = "creditorAccountNumber cannot be null")
    private String creditorAccountNumber;
    @NotNull(message = "amount cannot be null")
    private Double amount;
    @NotBlank(message = "currency cannot be null")
    private String currency;
    @NotNull(message = "schedule cannot be null")
    private ScheduleDto schedule;
    @NotBlank(message = "endToEndId cannot be null")
    private String endToEndId;
    @NotBlank(message = "remittanceInformation cannot be null")
    private String remittanceInformation;
}

