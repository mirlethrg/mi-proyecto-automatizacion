package cl.prodigio.sfa.api.scheduledpayment.dto.api.recurringpayment.request;

import cl.prodigio.sfa.api.scheduledpayment.dto.api.recurringpayment.common.ScheduleDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RecurringPaymentPjDto {
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
    private String creditorName;
    private String creditorIdentification;
    private String creditorAccountType;
    private String creditorAccountNumber;
    private Double amount;
    private String currency;
    private ScheduleDto schedule;
    private String endToEndId;
    private String remittanceInformation;
}
