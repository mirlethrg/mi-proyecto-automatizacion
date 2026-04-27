package com.mypolio.qa.paymentsystem.api.scheduledpayment.service.external;

import com.mypolio.qa.paymentsystem.api.scheduledpayment.dto.api.recurringpayment.request.RecurringPaymentsRequestPjDto;
import com.mypolio.qa.paymentsystem.api.scheduledpayment.dto.api.recurringpayment.request.RecurringPaymentsRequestPnDto;
import com.mypolio.qa.paymentsystem.api.scheduledpayment.dto.api.recurringpayment.response.RecurringPaymentResponsePjDto;
import com.mypolio.qa.paymentsystem.api.scheduledpayment.dto.api.recurringpayment.response.RecurringPaymentsResponsePnDto;
import com.mypolio.qa.paymentsystem.api.scheduledpayment.dto.api.recurringpayment.response.RecurringPaymentDetailResponseDto;

public interface MsRecurringPaymentIntegrationService {
    RecurringPaymentsResponsePnDto createRecurringPn(String interactionId, String jwsSignature, RecurringPaymentsRequestPnDto request, String idempotencyKey);

    RecurringPaymentResponsePjDto createRecurringPj(String interactionId, String jwsSignature, RecurringPaymentsRequestPjDto request, String idempotencyKey);

    RecurringPaymentDetailResponseDto getRecurringPayment(String paymentId, String participantType, String interactionId, String jwsSignature);
}

