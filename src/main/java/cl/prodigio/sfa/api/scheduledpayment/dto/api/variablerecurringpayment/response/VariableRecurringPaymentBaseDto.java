package cl.prodigio.sfa.api.scheduledpayment.dto.api.variablerecurringpayment.response;

import cl.prodigio.sfa.api.scheduledpayment.dto.api.common.LimitsResponseDto;
import cl.prodigio.sfa.api.scheduledpayment.dto.api.common.RecurrenceDto;
import cl.prodigio.sfa.api.scheduledpayment.dto.api.common.ScheduleDto;
import cl.prodigio.sfa.api.scheduledpayment.dto.api.common.StatusReasonDto;
import cl.prodigio.sfa.api.scheduledpayment.dto.api.variablerecurringpayment.common.AmountPolicyDto;
import cl.prodigio.sfa.api.scheduledpayment.dto.api.variablerecurringpayment.common.ExecutionsDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.OffsetDateTime;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public abstract class VariableRecurringPaymentBaseDto {
    private String recurringPaymentId;
    private String grantId;
    private OffsetDateTime creationDateTime;
    private OffsetDateTime statusUpdateDateTime;
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
