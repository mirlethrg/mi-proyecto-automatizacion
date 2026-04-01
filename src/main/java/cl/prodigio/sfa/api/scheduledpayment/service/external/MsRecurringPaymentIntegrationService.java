package cl.prodigio.sfa.api.scheduledpayment.service.external;

import cl.prodigio.sfa.api.scheduledpayment.dto.api.recurringpayment.request.PaymentsRequestPjDto;
import cl.prodigio.sfa.api.scheduledpayment.dto.api.recurringpayment.request.PaymentsRequestPnDto;
import cl.prodigio.sfa.api.scheduledpayment.dto.api.recurringpayment.response.PaymentsResponsePjDto;
import cl.prodigio.sfa.api.scheduledpayment.dto.api.recurringpayment.response.PaymentsResponsePnDto;
import cl.prodigio.sfa.api.scheduledpayment.dto.api.recurringpayment.response.RecurringPaymentDetailResponseDto;

public interface MsRecurringPaymentIntegrationService {
    PaymentsResponsePnDto createRecurringPn(String interactionId, String jwsSignature, PaymentsRequestPnDto request, String idempotencyKey);

    PaymentsResponsePjDto createRecurringPj(String interactionId, String jwsSignature, PaymentsRequestPjDto request, String idempotencyKey);

    RecurringPaymentDetailResponseDto getRecurringPayment(String paymentId, String participantType, String interactionId, String jwsSignature);
}
