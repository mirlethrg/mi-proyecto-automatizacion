package com.mypolio.qa.paymentsystem.api.scheduledpayment.service.core;

import com.mypolio.qa.paymentsystem.api.scheduledpayment.dto.api.request.ScheduledPaymentsRequestPnDto;
import com.mypolio.qa.paymentsystem.api.scheduledpayment.dto.api.request.ScheduledPaymentsRequestPjDto;
import com.mypolio.qa.paymentsystem.api.scheduledpayment.dto.api.response.ScheduledPaymentDetailResponseDto;
import com.mypolio.qa.paymentsystem.api.scheduledpayment.dto.api.response.ScheduledPaymentsResponsePnDto;
import com.mypolio.qa.paymentsystem.api.scheduledpayment.dto.api.response.ScheduledPaymentsResponsePjDto;

public interface ScheduledPaymentService {
    ScheduledPaymentsResponsePnDto createPn(String interactionId, String jwsSignature, ScheduledPaymentsRequestPnDto request, String idempotencyKey);
    ScheduledPaymentsResponsePjDto createPj(String interactionId, String jwsSignature, ScheduledPaymentsRequestPjDto request, String idempotencyKey);
    ScheduledPaymentDetailResponseDto get(String paymentId, String participantType, String interactionId, String jwsSignature);
}

