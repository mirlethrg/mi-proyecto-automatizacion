package cl.prodigio.sfa.api.scheduledpayment.service.core;

import cl.prodigio.sfa.api.scheduledpayment.dto.api.variablerecurringpayment.request.VariablePaymentRequestPnDto;
import cl.prodigio.sfa.api.scheduledpayment.dto.api.variablerecurringpayment.request.VariablePaymentRequestPjDto;
import cl.prodigio.sfa.api.scheduledpayment.dto.api.variablerecurringpayment.response.VariablePaymentResponsePnDto;
import cl.prodigio.sfa.api.scheduledpayment.dto.api.variablerecurringpayment.response.VariablePaymentResponsePjDto;
import cl.prodigio.sfa.api.scheduledpayment.dto.api.variablerecurringpayment.response.VariableRecurringPaymentDetailResponseDto;

public interface VariableRecurringPaymentService {
    VariablePaymentResponsePnDto createPn(String interactionId, String jwsSignature, VariablePaymentRequestPnDto request, String idempotencyKey);
    VariablePaymentResponsePjDto createPj(String interactionId, String jwsSignature, VariablePaymentRequestPjDto request, String idempotencyKey);
    VariableRecurringPaymentDetailResponseDto get(String paymentId, String participantType, String interactionId, String jwsSignature);
}
