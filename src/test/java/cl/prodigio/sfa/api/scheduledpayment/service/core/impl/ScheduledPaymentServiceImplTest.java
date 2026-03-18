package cl.prodigio.sfa.api.scheduledpayment.service.core.impl;

import cl.prodigio.sfa.api.scheduledpayment.dto.api.request.PaymentsRequestPjDto;
import cl.prodigio.sfa.api.scheduledpayment.dto.api.request.PaymentsRequestPnDto;
import cl.prodigio.sfa.api.scheduledpayment.dto.api.response.PaymentDetailResponseDto;
import cl.prodigio.sfa.api.scheduledpayment.dto.api.response.PaymentsResponsePjDto;
import cl.prodigio.sfa.api.scheduledpayment.dto.api.response.PaymentsResponsePnDto;
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
        PaymentsRequestPnDto request = PaymentsRequestPnDto.builder().build();
        PaymentsResponsePnDto expectedResponse = PaymentsResponsePnDto.builder().build();

        when(integrationService.createPn("interaction-id", "signature", request, "idempotency-key"))
                .thenReturn(expectedResponse);

        PaymentsResponsePnDto actualResponse = scheduledPaymentService.createPn("interaction-id", "signature", request, "idempotency-key");

        assertEquals(expectedResponse, actualResponse);
    }

    @Test
    void createPj_ShouldReturnResponse() {
        PaymentsRequestPjDto request = PaymentsRequestPjDto.builder().build();
        PaymentsResponsePjDto expectedResponse = PaymentsResponsePjDto.builder().build();

        when(integrationService.createPj("interaction-id", "signature", request, "idempotency-key"))
                .thenReturn(expectedResponse);

        PaymentsResponsePjDto actualResponse = scheduledPaymentService.createPj("interaction-id", "signature", request, "idempotency-key");

        assertEquals(expectedResponse, actualResponse);
    }

    @Test
    void get_ShouldReturnResponse() {
        PaymentDetailResponseDto expectedResponse = PaymentDetailResponseDto.builder().build();

        when(integrationService.get("PAY-123", "PN", "interaction-id", "signature"))
                .thenReturn(expectedResponse);

        PaymentDetailResponseDto actualResponse = scheduledPaymentService.get("PAY-123", "PN", "interaction-id", "signature");

        assertEquals(expectedResponse, actualResponse);
    }
}
