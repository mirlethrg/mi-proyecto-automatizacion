package com.mypolio.qa.paymentsystem.api.scheduledpayment.service.core.impl;

import com.mypolio.qa.paymentsystem.api.scheduledpayment.dto.api.recurringpayment.request.RecurringPaymentsRequestPjDto;
import com.mypolio.qa.paymentsystem.api.scheduledpayment.dto.api.recurringpayment.request.RecurringPaymentsRequestPnDto;
import com.mypolio.qa.paymentsystem.api.scheduledpayment.dto.api.recurringpayment.response.RecurringPaymentResponsePjDto;
import com.mypolio.qa.paymentsystem.api.scheduledpayment.dto.api.recurringpayment.response.RecurringPaymentsResponsePnDto;
import com.mypolio.qa.paymentsystem.api.scheduledpayment.dto.api.recurringpayment.response.RecurringPaymentDetailResponseDto;
import com.mypolio.qa.paymentsystem.api.scheduledpayment.service.core.RecurringPaymentService;
import com.mypolio.qa.paymentsystem.api.scheduledpayment.service.external.MsRecurringPaymentIntegrationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class RecurringPaymentServiceImpl implements RecurringPaymentService {

    private final MsRecurringPaymentIntegrationService integrationService;

    @Override
    public RecurringPaymentsResponsePnDto createPn(String interactionId, String jwsSignature, RecurringPaymentsRequestPnDto request, String idempotencyKey) {
        return integrationService.createRecurringPn(interactionId, jwsSignature, request, idempotencyKey);
    }

    @Override
    public RecurringPaymentResponsePjDto createPj(String interactionId, String jwsSignature, RecurringPaymentsRequestPjDto request, String idempotencyKey) {
        return integrationService.createRecurringPj(interactionId, jwsSignature, request, idempotencyKey);
    }

    @Override
    public RecurringPaymentDetailResponseDto get(String paymentId, String participantType, String interactionId, String jwsSignature) {
        return integrationService.getRecurringPayment(paymentId, participantType, interactionId, jwsSignature);
    }
}

