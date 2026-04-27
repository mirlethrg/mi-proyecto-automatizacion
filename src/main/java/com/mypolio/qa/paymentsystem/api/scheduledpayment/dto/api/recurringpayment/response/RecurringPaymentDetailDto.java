package com.mypolio.qa.paymentsystem.api.scheduledpayment.dto.api.recurringpayment.response;

import com.mypolio.qa.paymentsystem.api.scheduledpayment.dto.api.common.RecurrenceDto;
import com.mypolio.qa.paymentsystem.api.scheduledpayment.dto.api.common.ScheduleDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RecurringPaymentDetailDto {
    private String grantId;
    private String transactionType;
    private String debtorInstitutionId;
    private String debtorName;
    private String debtorIdentification;
    private String debtorAccountType;
    private String debtorAccountNumber;
    private String debtorRepresentativeId;
    private String debtorRepresentativeRole;
    private String creditorInstitutionId;
    private String creditorAccountNumber;
    private String creditorAccountType;
    private String creditorName;
    private String creditorIdentification;
    private Double amount;
    private String currency;
    private RecurrenceDto recurrence;
    private ScheduleDto schedule;
    private String executionTimeOfDay;
    private String timezone;
    private String cutoffProfile;
    private String endToEndId;
    private String remittanceInformation;
    private String requestDateTime;
}

