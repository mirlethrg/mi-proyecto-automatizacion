package com.mypolio.qa.paymentsystem.api.scheduledpayment.service.core.impl;

import com.mypolio.qa.paymentsystem.api.scheduledpayment.dto.api.variablerecurringpayment.request.VariablePaymentRequestPjDto;
import com.mypolio.qa.paymentsystem.api.scheduledpayment.dto.api.variablerecurringpayment.request.VariablePaymentRequestPnDto;
import com.mypolio.qa.paymentsystem.api.scheduledpayment.dto.api.variablerecurringpayment.response.VariablePaymentResponsePjDto;
import com.mypolio.qa.paymentsystem.api.scheduledpayment.dto.api.variablerecurringpayment.response.VariablePaymentResponsePnDto;
import com.mypolio.qa.paymentsystem.api.scheduledpayment.dto.api.variablerecurringpayment.response.VariableRecurringPaymentDetailResponseDto;
import com.mypolio.qa.paymentsystem.api.scheduledpayment.service.core.VariableRecurringPaymentService;
import com.mypolio.qa.paymentsystem.api.scheduledpayment.service.external.MsVariableRecurringPaymentIntegrationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class VariableRecurringPaymentServiceImpl implements VariableRecurringPaymentService {

    private final MsVariableRecurringPaymentIntegrationService integrationService;

    @Override
    public VariablePaymentResponsePnDto createPn(String interactionId, String jwsSignature, VariablePaymentRequestPnDto request, String idempotencyKey) {
        return integrationService.createVariableRecurringPn(interactionId, jwsSignature, request, idempotencyKey);
    }

    @Override
    public VariablePaymentResponsePjDto createPj(String interactionId, String jwsSignature, VariablePaymentRequestPjDto request, String idempotencyKey) {
        return integrationService.createVariableRecurringPj(interactionId, jwsSignature, request, idempotencyKey);
    }

    @Override
    public VariableRecurringPaymentDetailResponseDto get(String paymentId, String participantType, String interactionId, String jwsSignature) {
        return integrationService.getVariableRecurringPayment(paymentId, participantType, interactionId, jwsSignature);
    }
}

