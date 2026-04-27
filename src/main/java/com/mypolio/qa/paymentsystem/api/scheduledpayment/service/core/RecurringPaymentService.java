package com.mypolio.qa.paymentsystem.api.scheduledpayment.service.core;

import com.mypolio.qa.paymentsystem.api.scheduledpayment.dto.api.recurringpayment.request.RecurringPaymentsRequestPnDto;
import com.mypolio.qa.paymentsystem.api.scheduledpayment.dto.api.recurringpayment.request.RecurringPaymentsRequestPjDto;
import com.mypolio.qa.paymentsystem.api.scheduledpayment.dto.api.recurringpayment.response.RecurringPaymentsResponsePnDto;
import com.mypolio.qa.paymentsystem.api.scheduledpayment.dto.api.recurringpayment.response.RecurringPaymentResponsePjDto;
import com.mypolio.qa.paymentsystem.api.scheduledpayment.dto.api.recurringpayment.response.RecurringPaymentDetailResponseDto;

public interface RecurringPaymentService {
    RecurringPaymentsResponsePnDto createPn(String interactionId, String jwsSignature, RecurringPaymentsRequestPnDto request, String idempotencyKey);
    RecurringPaymentResponsePjDto createPj(String interactionId, String jwsSignature, RecurringPaymentsRequestPjDto request, String idempotencyKey);
    RecurringPaymentDetailResponseDto get(String paymentId, String participantType, String interactionId, String jwsSignature);
}

