package cl.prodigio.sfa.api.scheduledpayment.service.external.impl;

import cl.prodigio.sfa.api.scheduledpayment.dto.api.request.ScheduledPaymentsRequestPjDto;
import cl.prodigio.sfa.api.scheduledpayment.dto.api.request.ScheduledPaymentsRequestPnDto;
import cl.prodigio.sfa.api.scheduledpayment.dto.api.response.ScheduledPaymentDetailResponseDto;
import cl.prodigio.sfa.api.scheduledpayment.dto.api.response.ScheduledPaymentsResponsePjDto;
import cl.prodigio.sfa.api.scheduledpayment.dto.api.response.ScheduledPaymentsResponsePnDto;
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
class MsScheduledPaymentIntegrationServiceImplTest {

    @Mock
    private HttpClientService httpClientService;

    @InjectMocks
    private MsScheduledPaymentIntegrationServiceImpl integrationService;

    @BeforeEach
    void setUp() {
        ReflectionTestUtils.setField(integrationService, "baseUrl", "http://localhost:8081");
        ReflectionTestUtils.setField(integrationService, "connectionTimeout", 5000);
    }

    @Test
    void createScheduledPn_ShouldReturnResponse() {
        ScheduledPaymentsRequestPnDto request = ScheduledPaymentsRequestPnDto.builder().build();
        ScheduledPaymentsResponsePnDto expectedResponse = ScheduledPaymentsResponsePnDto.builder().build();

        when(httpClientService.postInternal(any(HttpRequestDto.class))).thenReturn(expectedResponse);

        ScheduledPaymentsResponsePnDto actualResponse = integrationService.createScheduledPn("interaction-id", "signature", request, "idempotency-key");

        assertEquals(expectedResponse, actualResponse);
    }

    @Test
    void createScheduledPj_ShouldReturnResponse() {
        ScheduledPaymentsRequestPjDto request = ScheduledPaymentsRequestPjDto.builder().build();
        ScheduledPaymentsResponsePjDto expectedResponse = ScheduledPaymentsResponsePjDto.builder().build();

        when(httpClientService.postInternal(any(HttpRequestDto.class))).thenReturn(expectedResponse);

        ScheduledPaymentsResponsePjDto actualResponse = integrationService.createScheduledPj("interaction-id", "signature", request, "idempotency-key");

        assertEquals(expectedResponse, actualResponse);
    }

    @Test
    void getScheduledPayment_ShouldReturnResponse() {
        ScheduledPaymentDetailResponseDto expectedResponse = ScheduledPaymentDetailResponseDto.builder().build();

        when(httpClientService.getInternal(any(HttpRequestDto.class))).thenReturn(expectedResponse);

        ScheduledPaymentDetailResponseDto actualResponse = integrationService.getScheduledPayment("PAY-123", "PN", "interaction-id", "signature");

        assertEquals(expectedResponse, actualResponse);
    }
}
