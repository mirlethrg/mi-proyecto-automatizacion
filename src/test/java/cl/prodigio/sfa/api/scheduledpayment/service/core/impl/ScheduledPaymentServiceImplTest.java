package cl.prodigio.sfa.api.scheduledpayment.service.core.impl;

import cl.prodigio.sfa.api.scheduledpayment.dto.api.request.ScheduledPaymentsRequestPjDto;
import cl.prodigio.sfa.api.scheduledpayment.dto.api.request.ScheduledPaymentsRequestPnDto;
import cl.prodigio.sfa.api.scheduledpayment.dto.api.response.ScheduledPaymentDetailResponseDto;
import cl.prodigio.sfa.api.scheduledpayment.dto.api.response.ScheduledPaymentsResponsePjDto;
import cl.prodigio.sfa.api.scheduledpayment.dto.api.response.ScheduledPaymentsResponsePnDto;
import cl.prodigio.sfa.api.scheduledpayment.service.external.MsScheduledPaymentIntegrationService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ScheduledPaymentServiceImplTest {

    @Mock
    private MsScheduledPaymentIntegrationService integrationService;

    @InjectMocks
    private ScheduledPaymentServiceImpl scheduledPaymentService;

    @Test
    void createPn_ShouldReturnResponse() {
        ScheduledPaymentsRequestPnDto request = ScheduledPaymentsRequestPnDto.builder().build();
        ScheduledPaymentsResponsePnDto expectedResponse = ScheduledPaymentsResponsePnDto.builder().build();

        when(integrationService.createScheduledPn("interaction-id", "signature", request, "idempotency-key"))
                .thenReturn(expectedResponse);

        ScheduledPaymentsResponsePnDto actualResponse = scheduledPaymentService.createPn("interaction-id", "signature", request, "idempotency-key");

        assertEquals(expectedResponse, actualResponse);
    }

    @Test
    void createPj_ShouldReturnResponse() {
        ScheduledPaymentsRequestPjDto request = ScheduledPaymentsRequestPjDto.builder().build();
        ScheduledPaymentsResponsePjDto expectedResponse = ScheduledPaymentsResponsePjDto.builder().build();

        when(integrationService.createScheduledPj("interaction-id", "signature", request, "idempotency-key"))
                .thenReturn(expectedResponse);

        ScheduledPaymentsResponsePjDto actualResponse = scheduledPaymentService.createPj("interaction-id", "signature", request, "idempotency-key");

        assertEquals(expectedResponse, actualResponse);
    }

    @Test
    void get_ShouldReturnResponse() {
        ScheduledPaymentDetailResponseDto expectedResponse = ScheduledPaymentDetailResponseDto.builder().build();

        when(integrationService.getScheduledPayment("PAY-123", "PN", "interaction-id", "signature"))
                .thenReturn(expectedResponse);

        ScheduledPaymentDetailResponseDto actualResponse = scheduledPaymentService.get("PAY-123", "PN", "interaction-id", "signature");

        assertEquals(expectedResponse, actualResponse);
    }
}
