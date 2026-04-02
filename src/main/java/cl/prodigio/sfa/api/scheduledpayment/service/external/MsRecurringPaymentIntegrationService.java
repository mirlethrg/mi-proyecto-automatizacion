package cl.prodigio.sfa.api.scheduledpayment.service.external;

import cl.prodigio.sfa.api.scheduledpayment.dto.api.recurringpayment.request.RecurringPaymentsRequestPjDto;
import cl.prodigio.sfa.api.scheduledpayment.dto.api.recurringpayment.request.RecurringPaymentsRequestPnDto;
import cl.prodigio.sfa.api.scheduledpayment.dto.api.recurringpayment.response.RecurringPaymentResponsePjDto;
import cl.prodigio.sfa.api.scheduledpayment.dto.api.recurringpayment.response.RecurringPaymentsResponsePnDto;
import cl.prodigio.sfa.api.scheduledpayment.dto.api.recurringpayment.response.RecurringPaymentDetailResponseDto;

public interface MsRecurringPaymentIntegrationService {
    RecurringPaymentsResponsePnDto createRecurringPn(String interactionId, String jwsSignature, RecurringPaymentsRequestPnDto request, String idempotencyKey);

    RecurringPaymentResponsePjDto createRecurringPj(String interactionId, String jwsSignature, RecurringPaymentsRequestPjDto request, String idempotencyKey);

    RecurringPaymentDetailResponseDto getRecurringPayment(String paymentId, String participantType, String interactionId, String jwsSignature);
}
