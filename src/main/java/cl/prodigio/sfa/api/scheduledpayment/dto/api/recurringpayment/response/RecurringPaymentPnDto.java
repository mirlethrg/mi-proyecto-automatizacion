package cl.prodigio.sfa.api.scheduledpayment.dto.api.recurringpayment.response;

import cl.prodigio.sfa.api.scheduledpayment.dto.api.common.ExecutionsSummaryDto;
import cl.prodigio.sfa.api.scheduledpayment.dto.api.common.LimitsResponseDto;
import cl.prodigio.sfa.api.scheduledpayment.dto.api.common.RecurrenceDto;
import cl.prodigio.sfa.api.scheduledpayment.dto.api.common.ScheduleDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.OffsetDateTime;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class RecurringPaymentPnDto {
    private String recurringPaymentId;
    private String grantId;
    private OffsetDateTime creationDateTime;
    private OffsetDateTime statusUpdateDateTime;
    private String paymentStatus;
    private OffsetDateTime nextExecutionDateTime;
    private OffsetDateTime lastExecutionDateTime;
    private ExecutionsSummaryDto executionsSummary;
    private LimitsResponseDto limits;
    private String debtorInstitutionId;
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
    private RecurrenceDto recurrence;
    private ScheduleDto schedule;
    private String executionTimeOfDay;
    private String timezone;
    private String cutoffProfile;
    private String endToEndId;
    private String remittanceInformation;
}
