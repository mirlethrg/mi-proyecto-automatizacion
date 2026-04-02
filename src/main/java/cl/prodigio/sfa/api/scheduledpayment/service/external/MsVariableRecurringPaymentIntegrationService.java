package cl.prodigio.sfa.api.scheduledpayment.service.external;

import cl.prodigio.sfa.api.scheduledpayment.dto.api.variablerecurringpayment.request.VariablePaymentRequestPjDto;
import cl.prodigio.sfa.api.scheduledpayment.dto.api.variablerecurringpayment.request.VariablePaymentRequestPnDto;
import cl.prodigio.sfa.api.scheduledpayment.dto.api.variablerecurringpayment.response.VariablePaymentResponsePjDto;
import cl.prodigio.sfa.api.scheduledpayment.dto.api.variablerecurringpayment.response.VariablePaymentResponsePnDto;
import cl.prodigio.sfa.api.scheduledpayment.dto.api.variablerecurringpayment.response.VariableRecurringPaymentDetailResponseDto;

public interface MsVariableRecurringPaymentIntegrationService {
    VariablePaymentResponsePnDto createVariableRecurringPn(String interactionId, String jwsSignature, VariablePaymentRequestPnDto request, String idempotencyKey);

    VariablePaymentResponsePjDto createVariableRecurringPj(String interactionId, String jwsSignature, VariablePaymentRequestPjDto request, String idempotencyKey);

    VariableRecurringPaymentDetailResponseDto getVariableRecurringPayment(String paymentId, String participantType, String interactionId, String jwsSignature);
}
