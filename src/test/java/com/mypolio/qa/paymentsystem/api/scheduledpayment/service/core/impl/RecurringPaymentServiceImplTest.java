package com.mypolio.qa.paymentsystem.api.scheduledpayment.service.core.impl;

import com.mypolio.qa.paymentsystem.api.scheduledpayment.dto.api.recurringpayment.request.RecurringPaymentsRequestPjDto;
import com.mypolio.qa.paymentsystem.api.scheduledpayment.dto.api.recurringpayment.request.RecurringPaymentsRequestPnDto;
import com.mypolio.qa.paymentsystem.api.scheduledpayment.dto.api.recurringpayment.response.RecurringPaymentResponsePjDto;
import com.mypolio.qa.paymentsystem.api.scheduledpayment.dto.api.recurringpayment.response.RecurringPaymentsResponsePnDto;
import com.mypolio.qa.paymentsystem.api.scheduledpayment.dto.api.recurringpayment.response.RecurringPaymentDetailResponseDto;
import com.mypolio.qa.paymentsystem.api.scheduledpayment.service.external.MsRecurringPaymentIntegrationService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RecurringPaymentServiceImplTest {

    @Mock
    private MsRecurringPaymentIntegrationService integrationService;

    @InjectMocks
    private RecurringPaymentServiceImpl recurringPaymentService;

    @Test
    void createPn_ShouldReturnResponse() {
        RecurringPaymentsRequestPnDto request = RecurringPaymentsRequestPnDto.builder().build();
        RecurringPaymentsResponsePnDto expectedResponse = RecurringPaymentsResponsePnDto.builder().build();

        when(integrationService.createRecurringPn("interaction-id", "signature", request, "idempotency-key"))
                .thenReturn(expectedResponse);

        RecurringPaymentsResponsePnDto actualResponse = recurringPaymentService.createPn("interaction-id", "signature", request, "idempotency-key");

        assertEquals(expectedResponse, actualResponse);
    }

    @Test
    void createPj_ShouldReturnResponse() {
        RecurringPaymentsRequestPjDto request = RecurringPaymentsRequestPjDto.builder().build();
        RecurringPaymentResponsePjDto expectedResponse = RecurringPaymentResponsePjDto.builder().build();

        when(integrationService.createRecurringPj("interaction-id", "signature", request, "idempotency-key"))
                .thenReturn(expectedResponse);

        RecurringPaymentResponsePjDto actualResponse = recurringPaymentService.createPj("interaction-id", "signature", request, "idempotency-key");

        assertEquals(expectedResponse, actualResponse);
    }

    @Test
    void get_ShouldReturnResponse() {
        RecurringPaymentDetailResponseDto expectedResponse = RecurringPaymentDetailResponseDto.builder().build();

        when(integrationService.getRecurringPayment("PAY-123", "PJ", "interaction-id", "signature"))
                .thenReturn(expectedResponse);

        RecurringPaymentDetailResponseDto actualResponse = recurringPaymentService.get("PAY-123", "PJ", "interaction-id", "signature");

        assertEquals(expectedResponse, actualResponse);
    }
}

