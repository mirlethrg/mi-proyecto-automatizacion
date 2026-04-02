package cl.prodigio.sfa.api.scheduledpayment.service.core;

import cl.prodigio.sfa.api.scheduledpayment.dto.api.request.ScheduledPaymentsRequestPnDto;
import cl.prodigio.sfa.api.scheduledpayment.dto.api.request.ScheduledPaymentsRequestPjDto;
import cl.prodigio.sfa.api.scheduledpayment.dto.api.response.ScheduledPaymentDetailResponseDto;
import cl.prodigio.sfa.api.scheduledpayment.dto.api.response.ScheduledPaymentsResponsePnDto;
import cl.prodigio.sfa.api.scheduledpayment.dto.api.response.ScheduledPaymentsResponsePjDto;

public interface ScheduledPaymentService {
    ScheduledPaymentsResponsePnDto createPn(String interactionId, String jwsSignature, ScheduledPaymentsRequestPnDto request, String idempotencyKey);
    ScheduledPaymentsResponsePjDto createPj(String interactionId, String jwsSignature, ScheduledPaymentsRequestPjDto request, String idempotencyKey);
    ScheduledPaymentDetailResponseDto get(String paymentId, String participantType, String interactionId, String jwsSignature);
}
