package cl.prodigio.sfa.api.scheduledpayment.service.external;

import cl.prodigio.sfa.api.scheduledpayment.dto.api.request.PaymentsRequestPnDto;
import cl.prodigio.sfa.api.scheduledpayment.dto.api.request.PaymentsRequestPjDto;
import cl.prodigio.sfa.api.scheduledpayment.dto.api.response.PaymentDetailResponseDto;
import cl.prodigio.sfa.api.scheduledpayment.dto.api.response.PaymentsResponsePnDto;
import cl.prodigio.sfa.api.scheduledpayment.dto.api.response.PaymentsResponsePjDto;

public interface MsScheduledPaymentIntegrationService {
    PaymentsResponsePnDto createPn(String interactionId, String jwsSignature, PaymentsRequestPnDto request, String idempotencyKey);
    PaymentsResponsePjDto createPj(String interactionId, String jwsSignature, PaymentsRequestPjDto request, String idempotencyKey);
    PaymentDetailResponseDto get(String paymentId, String participantType, String interactionId, String jwsSignature);
}
