package cl.prodigio.sfa.api.scheduledpayment.service.core.impl;

import cl.prodigio.sfa.api.scheduledpayment.dto.api.recurringpayment.request.RecurringPaymentsRequestPjDto;
import cl.prodigio.sfa.api.scheduledpayment.dto.api.recurringpayment.request.RecurringPaymentsRequestPnDto;
import cl.prodigio.sfa.api.scheduledpayment.dto.api.recurringpayment.response.RecurringPaymentResponsePjDto;
import cl.prodigio.sfa.api.scheduledpayment.dto.api.recurringpayment.response.RecurringPaymentsResponsePnDto;
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
    public RecurringPaymentsResponsePnDto createPn(String interactionId, String jwsSignature, RecurringPaymentsRequestPnDto request, String idempotencyKey) {
        return integrationService.createRecurringPn(interactionId, jwsSignature, request, idempotencyKey);
    }

    @Override
    public RecurringPaymentResponsePjDto createPj(String interactionId, String jwsSignature, RecurringPaymentsRequestPjDto request, String idempotencyKey) {
        return integrationService.createRecurringPj(interactionId, jwsSignature, request, idempotencyKey);
    }

    @Override
    public RecurringPaymentDetailResponseDto get(String paymentId, String participantType, String interactionId, String jwsSignature) {
        return integrationService.getRecurringPayment(paymentId, participantType, interactionId, jwsSignature);
    }
}
