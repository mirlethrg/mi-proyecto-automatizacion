package cl.prodigio.sfa.api.scheduledpayment.service.external;

import cl.prodigio.sfa.api.scheduledpayment.dto.api.request.ScheduledPaymentsRequestPjDto;
import cl.prodigio.sfa.api.scheduledpayment.dto.api.request.ScheduledPaymentsRequestPnDto;
import cl.prodigio.sfa.api.scheduledpayment.dto.api.response.ScheduledPaymentDetailResponseDto;
import cl.prodigio.sfa.api.scheduledpayment.dto.api.response.ScheduledPaymentsResponsePjDto;
import cl.prodigio.sfa.api.scheduledpayment.dto.api.response.ScheduledPaymentsResponsePnDto;

public interface MsScheduledPaymentIntegrationService {
    ScheduledPaymentsResponsePnDto createScheduledPn(String interactionId, String jwsSignature, ScheduledPaymentsRequestPnDto request, String idempotencyKey);

    ScheduledPaymentsResponsePjDto createScheduledPj(String interactionId, String jwsSignature, ScheduledPaymentsRequestPjDto request, String idempotencyKey);

    ScheduledPaymentDetailResponseDto getScheduledPayment(String paymentId, String participantType, String interactionId, String jwsSignature);
}
