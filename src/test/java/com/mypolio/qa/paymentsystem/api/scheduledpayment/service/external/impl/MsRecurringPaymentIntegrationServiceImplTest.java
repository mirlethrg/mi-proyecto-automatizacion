package com.mypolio.qa.paymentsystem.api.scheduledpayment.service.external.impl;

import com.mypolio.qa.paymentsystem.api.scheduledpayment.dto.api.recurringpayment.request.RecurringPaymentsRequestPjDto;
import com.mypolio.qa.paymentsystem.api.scheduledpayment.dto.api.recurringpayment.request.RecurringPaymentsRequestPnDto;
import com.mypolio.qa.paymentsystem.api.scheduledpayment.dto.api.recurringpayment.response.RecurringPaymentResponsePjDto;
import com.mypolio.qa.paymentsystem.api.scheduledpayment.dto.api.recurringpayment.response.RecurringPaymentsResponsePnDto;
import com.mypolio.qa.paymentsystem.api.scheduledpayment.dto.api.recurringpayment.response.RecurringPaymentDetailResponseDto;
import com.mypolio.qa.paymentsystem.core.services.http.HttpClientService;
import com.mypolio.qa.paymentsystem.core.services.http.HttpRequestDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MsRecurringPaymentIntegrationServiceImplTest {

    @Mock
    private HttpClientService httpClientService;

    @InjectMocks
    private MsRecurringPaymentIntegrationServiceImpl integrationService;

    @BeforeEach
    void setUp() {
        ReflectionTestUtils.setField(integrationService, "baseUrl", "http://localhost:8081");
        ReflectionTestUtils.setField(integrationService, "connectionTimeout", 5000);
    }

    @Test
    void createRecurringPn_ShouldReturnResponse() {
        RecurringPaymentsRequestPnDto request = RecurringPaymentsRequestPnDto.builder().build();
        RecurringPaymentsResponsePnDto expectedResponse = RecurringPaymentsResponsePnDto.builder().build();

        when(httpClientService.postInternal(any(HttpRequestDto.class))).thenReturn(expectedResponse);

        RecurringPaymentsResponsePnDto actualResponse = integrationService.createRecurringPn("interaction-id", "signature", request, "idempotency-key");

        assertEquals(expectedResponse, actualResponse);
    }

    @Test
    void createRecurringPj_ShouldReturnResponse() {
        RecurringPaymentsRequestPjDto request = RecurringPaymentsRequestPjDto.builder().build();
        RecurringPaymentResponsePjDto expectedResponse = RecurringPaymentResponsePjDto.builder().build();

        when(httpClientService.postInternal(any(HttpRequestDto.class))).thenReturn(expectedResponse);

        RecurringPaymentResponsePjDto actualResponse = integrationService.createRecurringPj("interaction-id", "signature", request, "idempotency-key");

        assertEquals(expectedResponse, actualResponse);
    }

    @Test
    void getRecurringPayment_ShouldReturnResponse() {
        RecurringPaymentDetailResponseDto expectedResponse = RecurringPaymentDetailResponseDto.builder().build();

        when(httpClientService.getInternal(any(HttpRequestDto.class))).thenReturn(expectedResponse);

        RecurringPaymentDetailResponseDto actualResponse = integrationService.getRecurringPayment("PAY-123", "PJ", "interaction-id", "signature");

        assertEquals(expectedResponse, actualResponse);
    }
}

