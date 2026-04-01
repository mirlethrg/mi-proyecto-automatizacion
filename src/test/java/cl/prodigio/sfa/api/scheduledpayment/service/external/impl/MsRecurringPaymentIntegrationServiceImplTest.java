package cl.prodigio.sfa.api.scheduledpayment.service.external.impl;

import cl.prodigio.sfa.api.scheduledpayment.dto.api.recurringpayment.request.PaymentsRequestPjDto;
import cl.prodigio.sfa.api.scheduledpayment.dto.api.recurringpayment.request.PaymentsRequestPnDto;
import cl.prodigio.sfa.api.scheduledpayment.dto.api.recurringpayment.response.PaymentsResponsePjDto;
import cl.prodigio.sfa.api.scheduledpayment.dto.api.recurringpayment.response.PaymentsResponsePnDto;
import cl.prodigio.sfa.api.scheduledpayment.dto.api.recurringpayment.response.RecurringPaymentDetailResponseDto;
import cl.prodigio.sfa.core.services.http.HttpClientService;
import cl.prodigio.sfa.core.services.http.HttpRequestDto;
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
    void createPn_ShouldReturnResponse() {
        PaymentsRequestPnDto request = PaymentsRequestPnDto.builder().build();
        PaymentsResponsePnDto expectedResponse = PaymentsResponsePnDto.builder().build();

        when(httpClientService.postInternal(any(HttpRequestDto.class))).thenReturn(expectedResponse);

        PaymentsResponsePnDto actualResponse = integrationService.createPn("interaction-id", "signature", request, "idempotency-key");

        assertEquals(expectedResponse, actualResponse);
    }

    @Test
    void createPj_ShouldReturnResponse() {
        PaymentsRequestPjDto request = PaymentsRequestPjDto.builder().build();
        PaymentsResponsePjDto expectedResponse = PaymentsResponsePjDto.builder().build();

        when(httpClientService.postInternal(any(HttpRequestDto.class))).thenReturn(expectedResponse);

        PaymentsResponsePjDto actualResponse = integrationService.createPj("interaction-id", "signature", request, "idempotency-key");

        assertEquals(expectedResponse, actualResponse);
    }

    @Test
    void get_ShouldReturnResponse() {
        RecurringPaymentDetailResponseDto expectedResponse = RecurringPaymentDetailResponseDto.builder().build();

        when(httpClientService.getInternal(any(HttpRequestDto.class))).thenReturn(expectedResponse);

        RecurringPaymentDetailResponseDto actualResponse = integrationService.get("PAY-123", "PJ", "interaction-id", "signature");

        assertEquals(expectedResponse, actualResponse);
    }
}
