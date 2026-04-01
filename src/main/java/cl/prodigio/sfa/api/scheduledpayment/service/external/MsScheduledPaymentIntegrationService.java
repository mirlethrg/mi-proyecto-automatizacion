package cl.prodigio.sfa.api.scheduledpayment.service.external;

import cl.prodigio.sfa.api.scheduledpayment.dto.api.request.PaymentsRequestPjDto;
import cl.prodigio.sfa.api.scheduledpayment.dto.api.request.PaymentsRequestPnDto;
import cl.prodigio.sfa.api.scheduledpayment.dto.api.response.PaymentDetailResponseDto;
import cl.prodigio.sfa.api.scheduledpayment.dto.api.response.PaymentsResponsePjDto;
import cl.prodigio.sfa.api.scheduledpayment.dto.api.response.PaymentsResponsePnDto;

public interface MsScheduledPaymentIntegrationService {
    PaymentsResponsePnDto createScheduledPn(String interactionId, String jwsSignature, PaymentsRequestPnDto request, String idempotencyKey);

    PaymentsResponsePjDto createScheduledPj(String interactionId, String jwsSignature, PaymentsRequestPjDto request, String idempotencyKey);

    PaymentDetailResponseDto getScheduledPayment(String paymentId, String participantType, String interactionId, String jwsSignature);
}
