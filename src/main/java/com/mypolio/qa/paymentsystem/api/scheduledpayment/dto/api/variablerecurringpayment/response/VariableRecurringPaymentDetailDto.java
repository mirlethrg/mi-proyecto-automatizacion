package com.mypolio.qa.paymentsystem.api.scheduledpayment.dto.api.variablerecurringpayment.response;

import com.mypolio.qa.paymentsystem.api.scheduledpayment.dto.api.common.LimitsResponseDto;
import com.mypolio.qa.paymentsystem.api.scheduledpayment.dto.api.common.RecurrenceDto;
import com.mypolio.qa.paymentsystem.api.scheduledpayment.dto.api.common.ScheduleDto;
import com.mypolio.qa.paymentsystem.api.scheduledpayment.dto.api.common.StatusReasonDto;
import com.mypolio.qa.paymentsystem.api.scheduledpayment.dto.api.variablerecurringpayment.common.AmountPolicyDto;
import com.mypolio.qa.paymentsystem.api.scheduledpayment.dto.api.variablerecurringpayment.common.ExecutionsDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VariableRecurringPaymentDetailDto {
    private String recurringPaymentId;
    private String grantId;
    private OffsetDateTime creationDateTime;
    private OffsetDateTime statusUpdateDateTime;
    private String paymentStatus;
    private StatusReasonDto statusReason;
    private OffsetDateTime nextExecutionDateTime;
    private OffsetDateTime lastExecutionDateTime;
    private ExecutionsDto executions;
    private LimitsResponseDto limits;
    private AmountPolicyDto amountPolicy;
    private String debtorInstitutionId;
    private String debtorAccountNumber;
    private String debtorAccountType;
    private String debtorName;
    private String debtorIdentification;
    private String debtorRepresentativeId;
    private String debtorRepresentativeRole;
    private String creditorInstitutionId;
    private String creditorAccountNumber;
    private String creditorAccountType;
    private String creditorName;
    private String creditorIdentification;
    private RecurrenceDto recurrence;
    private ScheduleDto schedule;
    private String executionTimeOfDay;
    private String timezone;
    private String cutoffProfile;
    private String endToEndId;
    private String remittanceInformation;
}

