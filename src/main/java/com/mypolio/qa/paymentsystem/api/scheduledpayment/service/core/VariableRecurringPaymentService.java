package com.mypolio.qa.paymentsystem.api.scheduledpayment.service.core;

import com.mypolio.qa.paymentsystem.api.scheduledpayment.dto.api.variablerecurringpayment.request.VariablePaymentRequestPnDto;
import com.mypolio.qa.paymentsystem.api.scheduledpayment.dto.api.variablerecurringpayment.request.VariablePaymentRequestPjDto;
import com.mypolio.qa.paymentsystem.api.scheduledpayment.dto.api.variablerecurringpayment.response.VariablePaymentResponsePnDto;
import com.mypolio.qa.paymentsystem.api.scheduledpayment.dto.api.variablerecurringpayment.response.VariablePaymentResponsePjDto;
import com.mypolio.qa.paymentsystem.api.scheduledpayment.dto.api.variablerecurringpayment.response.VariableRecurringPaymentDetailResponseDto;

public interface VariableRecurringPaymentService {
    VariablePaymentResponsePnDto createPn(String interactionId, String jwsSignature, VariablePaymentRequestPnDto request, String idempotencyKey);
    VariablePaymentResponsePjDto createPj(String interactionId, String jwsSignature, VariablePaymentRequestPjDto request, String idempotencyKey);
    VariableRecurringPaymentDetailResponseDto get(String paymentId, String participantType, String interactionId, String jwsSignature);
}

