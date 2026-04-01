package cl.prodigio.sfa.api.scheduledpayment.service.core.impl;

import cl.prodigio.sfa.api.scheduledpayment.dto.api.variablerecurringpayment.request.PaymentsRequestPjDto;
import cl.prodigio.sfa.api.scheduledpayment.dto.api.variablerecurringpayment.request.PaymentsRequestPnDto;
import cl.prodigio.sfa.api.scheduledpayment.dto.api.variablerecurringpayment.response.PaymentsResponsePjDto;
import cl.prodigio.sfa.api.scheduledpayment.dto.api.variablerecurringpayment.response.PaymentsResponsePnDto;
import cl.prodigio.sfa.api.scheduledpayment.dto.api.variablerecurringpayment.response.VariableRecurringPaymentDetailResponseDto;
import cl.prodigio.sfa.api.scheduledpayment.service.core.VariableRecurringPaymentService;
import cl.prodigio.sfa.api.scheduledpayment.service.external.MsVariableRecurringPaymentIntegrationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class VariableRecurringPaymentServiceImpl implements VariableRecurringPaymentService {

    private final MsVariableRecurringPaymentIntegrationService integrationService;

    @Override
    public PaymentsResponsePnDto createPn(String interactionId, String jwsSignature, PaymentsRequestPnDto request, String idempotencyKey) {
        return integrationService.createVariableRecurringPn(interactionId, jwsSignature, request, idempotencyKey);
    }

    @Override
    public PaymentsResponsePjDto createPj(String interactionId, String jwsSignature, PaymentsRequestPjDto request, String idempotencyKey) {
        return integrationService.createVariableRecurringPj(interactionId, jwsSignature, request, idempotencyKey);
    }

    @Override
    public VariableRecurringPaymentDetailResponseDto get(String paymentId, String participantType, String interactionId, String jwsSignature) {
        return integrationService.getVariableRecurringPayment(paymentId, participantType, interactionId, jwsSignature);
    }
}
