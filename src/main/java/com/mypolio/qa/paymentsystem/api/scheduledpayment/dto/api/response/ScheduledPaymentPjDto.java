package com.mypolio.qa.paymentsystem.api.scheduledpayment.dto.api.response;

import com.mypolio.qa.paymentsystem.api.scheduledpayment.dto.api.common.ExecutionWindowDto;
import com.mypolio.qa.paymentsystem.api.scheduledpayment.dto.api.common.StatusReasonDto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ScheduledPaymentPjDto {
    private String paymentId;
    private String grantId;
    private OffsetDateTime creationDateTime;
    private OffsetDateTime statusUpdateDateTime;
    private String paymentStatus;
    private String transactionType;
    private String endToEndId;
    private String bankTrackingId;
    private String debtorName;
    private String debtorAccountNumber;
    private String debtorAccountType;
    private String debtorIdentification;
    private String creditorInstitutionId;
    private String creditorAccountNumber;
    private String creditorAccountType;
    private String creditorName;
    private String creditorIdentification;
    private Double amount;
    private String currency;
    private String remittanceInformation;
}

