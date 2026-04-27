package com.mypolio.qa.paymentsystem.api.scheduledpayment.service.external;

import com.mypolio.qa.paymentsystem.api.scheduledpayment.dto.api.request.ScheduledPaymentsRequestPjDto;
import com.mypolio.qa.paymentsystem.api.scheduledpayment.dto.api.request.ScheduledPaymentsRequestPnDto;
import com.mypolio.qa.paymentsystem.api.scheduledpayment.dto.api.response.ScheduledPaymentDetailResponseDto;
import com.mypolio.qa.paymentsystem.api.scheduledpayment.dto.api.response.ScheduledPaymentsResponsePjDto;
import com.mypolio.qa.paymentsystem.api.scheduledpayment.dto.api.response.ScheduledPaymentsResponsePnDto;

public interface MsScheduledPaymentIntegrationService {
    ScheduledPaymentsResponsePnDto createScheduledPn(String interactionId, String jwsSignature, ScheduledPaymentsRequestPnDto request, String idempotencyKey);

    ScheduledPaymentsResponsePjDto createScheduledPj(String interactionId, String jwsSignature, ScheduledPaymentsRequestPjDto request, String idempotencyKey);

    ScheduledPaymentDetailResponseDto getScheduledPayment(String paymentId, String participantType, String interactionId, String jwsSignature);
}

