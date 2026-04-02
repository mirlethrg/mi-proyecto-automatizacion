package cl.prodigio.sfa.api.scheduledpayment.service.core.impl;

import cl.prodigio.sfa.api.scheduledpayment.dto.api.request.ScheduledPaymentsRequestPjDto;
import cl.prodigio.sfa.api.scheduledpayment.dto.api.request.ScheduledPaymentsRequestPnDto;
import cl.prodigio.sfa.api.scheduledpayment.dto.api.response.ScheduledPaymentDetailResponseDto;
import cl.prodigio.sfa.api.scheduledpayment.dto.api.response.ScheduledPaymentsResponsePjDto;
import cl.prodigio.sfa.api.scheduledpayment.dto.api.response.ScheduledPaymentsResponsePnDto;
import cl.prodigio.sfa.api.scheduledpayment.service.core.ScheduledPaymentService;
import cl.prodigio.sfa.api.scheduledpayment.service.external.MsScheduledPaymentIntegrationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ScheduledPaymentServiceImpl implements ScheduledPaymentService {

    private final MsScheduledPaymentIntegrationService integrationService;

    @Override
    public ScheduledPaymentsResponsePnDto createPn(String interactionId, String jwsSignature, ScheduledPaymentsRequestPnDto request, String idempotencyKey) {
        return integrationService.createScheduledPn(interactionId, jwsSignature, request, idempotencyKey);
    }

    @Override
    public ScheduledPaymentsResponsePjDto createPj(String interactionId, String jwsSignature, ScheduledPaymentsRequestPjDto request, String idempotencyKey) {
        return integrationService.createScheduledPj(interactionId, jwsSignature, request, idempotencyKey);
    }

    @Override
    public ScheduledPaymentDetailResponseDto get(String paymentId, String participantType, String interactionId, String jwsSignature) {
        return integrationService.getScheduledPayment(paymentId, participantType, interactionId, jwsSignature);
    }
}
