package cl.prodigio.sfa.api.scheduledpayment.service.core;

import cl.prodigio.sfa.api.scheduledpayment.dto.api.recurringpayment.request.RecurringPaymentsRequestPnDto;
import cl.prodigio.sfa.api.scheduledpayment.dto.api.recurringpayment.request.RecurringPaymentsRequestPjDto;
import cl.prodigio.sfa.api.scheduledpayment.dto.api.recurringpayment.response.RecurringPaymentsResponsePnDto;
import cl.prodigio.sfa.api.scheduledpayment.dto.api.recurringpayment.response.RecurringPaymentResponsePjDto;
import cl.prodigio.sfa.api.scheduledpayment.dto.api.recurringpayment.response.RecurringPaymentDetailResponseDto;

public interface RecurringPaymentService {
    RecurringPaymentsResponsePnDto createPn(String interactionId, String jwsSignature, RecurringPaymentsRequestPnDto request, String idempotencyKey);
    RecurringPaymentResponsePjDto createPj(String interactionId, String jwsSignature, RecurringPaymentsRequestPjDto request, String idempotencyKey);
    RecurringPaymentDetailResponseDto get(String paymentId, String participantType, String interactionId, String jwsSignature);
}
