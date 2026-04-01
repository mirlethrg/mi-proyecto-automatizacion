package cl.prodigio.sfa.api.scheduledpayment.service.core.impl;

import cl.prodigio.sfa.api.scheduledpayment.dto.api.recurringpayment.request.PaymentsRequestPjDto;
import cl.prodigio.sfa.api.scheduledpayment.dto.api.recurringpayment.request.PaymentsRequestPnDto;
import cl.prodigio.sfa.api.scheduledpayment.dto.api.recurringpayment.response.PaymentsResponsePjDto;
import cl.prodigio.sfa.api.scheduledpayment.dto.api.recurringpayment.response.PaymentsResponsePnDto;
import cl.prodigio.sfa.api.scheduledpayment.dto.api.recurringpayment.response.RecurringPaymentDetailResponseDto;
import cl.prodigio.sfa.api.scheduledpayment.service.core.RecurringPaymentService;
import cl.prodigio.sfa.api.scheduledpayment.service.external.MsRecurringPaymentIntegrationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class RecurringPaymentServiceImpl implements RecurringPaymentService {

    private final MsRecurringPaymentIntegrationService integrationService;

    @Override
    public PaymentsResponsePnDto createPn(String interactionId, String jwsSignature, PaymentsRequestPnDto request, String idempotencyKey) {
        return integrationService.createPn(interactionId, jwsSignature, request, idempotencyKey);
    }

    @Override
    public PaymentsResponsePjDto createPj(String interactionId, String jwsSignature, PaymentsRequestPjDto request, String idempotencyKey) {
        return integrationService.createPj(interactionId, jwsSignature, request, idempotencyKey);
    }

    @Override
    public RecurringPaymentDetailResponseDto get(String paymentId, String participantType, String interactionId, String jwsSignature) {
        return integrationService.get(paymentId, participantType, interactionId, jwsSignature);
    }
}
