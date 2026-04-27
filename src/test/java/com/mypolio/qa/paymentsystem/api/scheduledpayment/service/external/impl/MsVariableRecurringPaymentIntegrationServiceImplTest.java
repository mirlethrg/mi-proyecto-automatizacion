package com.mypolio.qa.paymentsystem.api.scheduledpayment.service.external.impl;

import com.mypolio.qa.paymentsystem.api.scheduledpayment.dto.api.variablerecurringpayment.request.VariablePaymentRequestPjDto;
import com.mypolio.qa.paymentsystem.api.scheduledpayment.dto.api.variablerecurringpayment.request.VariablePaymentRequestPnDto;
import com.mypolio.qa.paymentsystem.api.scheduledpayment.dto.api.variablerecurringpayment.response.VariablePaymentResponsePjDto;
import com.mypolio.qa.paymentsystem.api.scheduledpayment.dto.api.variablerecurringpayment.response.VariablePaymentResponsePnDto;
import com.mypolio.qa.paymentsystem.api.scheduledpayment.dto.api.variablerecurringpayment.response.VariableRecurringPaymentDetailResponseDto;
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
class MsVariableRecurringPaymentIntegrationServiceImplTest {

    @Mock
    private HttpClientService httpClientService;

    @InjectMocks
    private MsVariableRecurringPaymentIntegrationServiceImpl integrationService;

    @BeforeEach
    void setUp() {
        ReflectionTestUtils.setField(integrationService, "baseUrl", "http://localhost:8081");
        ReflectionTestUtils.setField(integrationService, "connectionTimeout", 5000);
    }

    @Test
    void createVariableRecurringPn_ShouldReturnResponse() {
        VariablePaymentRequestPnDto request = VariablePaymentRequestPnDto.builder().build();
        VariablePaymentResponsePnDto expectedResponse = VariablePaymentResponsePnDto.builder().build();

        when(httpClientService.postInternal(any(HttpRequestDto.class))).thenReturn(expectedResponse);

        VariablePaymentResponsePnDto actualResponse = integrationService.createVariableRecurringPn("interaction-id", "signature", request, "idempotency-key");

        assertEquals(expectedResponse, actualResponse);
    }

    @Test
    void createVariableRecurringPj_ShouldReturnResponse() {
        VariablePaymentRequestPjDto request = VariablePaymentRequestPjDto.builder().build();
        VariablePaymentResponsePjDto expectedResponse = VariablePaymentResponsePjDto.builder().build();

        when(httpClientService.postInternal(any(HttpRequestDto.class))).thenReturn(expectedResponse);

        VariablePaymentResponsePjDto actualResponse = integrationService.createVariableRecurringPj("interaction-id", "signature", request, "idempotency-key");

        assertEquals(expectedResponse, actualResponse);
    }

    @Test
    void getVariableRecurringPayment_ShouldReturnResponse() {
        VariableRecurringPaymentDetailResponseDto expectedResponse = VariableRecurringPaymentDetailResponseDto.builder().build();

        when(httpClientService.getInternal(any(HttpRequestDto.class))).thenReturn(expectedResponse);

        VariableRecurringPaymentDetailResponseDto actualResponse = integrationService.getVariableRecurringPayment("PAY-123", "PN", "interaction-id", "signature");

        assertEquals(expectedResponse, actualResponse);
    }
}

