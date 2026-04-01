package cl.prodigio.sfa.api.scheduledpayment.service.core;

import cl.prodigio.sfa.api.scheduledpayment.dto.api.recurringpayment.request.PaymentsRequestPnDto;
import cl.prodigio.sfa.api.scheduledpayment.dto.api.recurringpayment.request.PaymentsRequestPjDto;
import cl.prodigio.sfa.api.scheduledpayment.dto.api.recurringpayment.response.PaymentsResponsePnDto;
import cl.prodigio.sfa.api.scheduledpayment.dto.api.recurringpayment.response.PaymentsResponsePjDto;
import cl.prodigio.sfa.api.scheduledpayment.dto.api.recurringpayment.response.RecurringPaymentDetailResponseDto;

public interface RecurringPaymentService {
    PaymentsResponsePnDto createPn(String interactionId, String jwsSignature, PaymentsRequestPnDto request, String idempotencyKey);
    PaymentsResponsePjDto createPj(String interactionId, String jwsSignature, PaymentsRequestPjDto request, String idempotencyKey);
    RecurringPaymentDetailResponseDto get(String paymentId, String participantType, String interactionId, String jwsSignature);
}
