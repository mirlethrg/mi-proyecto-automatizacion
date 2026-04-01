package cl.prodigio.sfa.api.scheduledpayment.service.external;

import cl.prodigio.sfa.api.scheduledpayment.dto.api.variablerecurringpayment.request.PaymentsRequestPjDto;
import cl.prodigio.sfa.api.scheduledpayment.dto.api.variablerecurringpayment.request.PaymentsRequestPnDto;
import cl.prodigio.sfa.api.scheduledpayment.dto.api.variablerecurringpayment.response.PaymentsResponsePjDto;
import cl.prodigio.sfa.api.scheduledpayment.dto.api.variablerecurringpayment.response.PaymentsResponsePnDto;
import cl.prodigio.sfa.api.scheduledpayment.dto.api.variablerecurringpayment.response.VariableRecurringPaymentDetailResponseDto;

public interface MsVariableRecurringPaymentIntegrationService {
    PaymentsResponsePnDto createVariableRecurringPn(String interactionId, String jwsSignature, PaymentsRequestPnDto request, String idempotencyKey);

    PaymentsResponsePjDto createVariableRecurringPj(String interactionId, String jwsSignature, PaymentsRequestPjDto request, String idempotencyKey);

    VariableRecurringPaymentDetailResponseDto getVariableRecurringPayment(String paymentId, String participantType, String interactionId, String jwsSignature);
}
