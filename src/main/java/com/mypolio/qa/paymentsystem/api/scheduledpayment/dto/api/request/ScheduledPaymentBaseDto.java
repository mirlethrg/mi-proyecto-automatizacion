package com.mypolio.qa.paymentsystem.api.scheduledpayment.dto.api.request;

import com.mypolio.qa.paymentsystem.api.scheduledpayment.dto.api.common.ExecutionWindowDto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import java.time.OffsetDateTime;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public abstract class ScheduledPaymentBaseDto {
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

    @NotNull(message = "requestedExecutionDateTime cannot be null")
    private OffsetDateTime requestedExecutionDateTime;
    @NotNull(message = "executionWindow cannot be null")
    private ExecutionWindowDto executionWindow;
    @NotNull(message = "cutoffProfile cannot be null")
    private String cutoffProfile;

    @NotBlank(message = "endToEndId cannot be null")
    private String endToEndId;
    @NotBlank(message = "remittanceInformation cannot be null")
    private String remittanceInformation;
    @NotNull(message = "requestDateTime cannot be null")
    private OffsetDateTime requestDateTime;
}

