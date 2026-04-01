package cl.prodigio.sfa.api.scheduledpayment.service.core.impl;

import cl.prodigio.sfa.api.scheduledpayment.dto.api.recurringpayment.request.PaymentsRequestPjDto;
import cl.prodigio.sfa.api.scheduledpayment.dto.api.recurringpayment.request.PaymentsRequestPnDto;
import cl.prodigio.sfa.api.scheduledpayment.dto.api.recurringpayment.response.PaymentsResponsePjDto;
import cl.prodigio.sfa.api.scheduledpayment.dto.api.recurringpayment.response.PaymentsResponsePnDto;
import cl.prodigio.sfa.api.scheduledpayment.dto.api.recurringpayment.response.RecurringPaymentDetailResponseDto;
import cl.prodigio.sfa.api.scheduledpayment.service.external.MsRecurringPaymentIntegrationService;
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
        PaymentsRequestPnDto request = PaymentsRequestPnDto.builder().build();
        PaymentsResponsePnDto expectedResponse = PaymentsResponsePnDto.builder().build();

        when(integrationService.createPn("interaction-id", "signature", request, "idempotency-key"))
                .thenReturn(expectedResponse);

        PaymentsResponsePnDto actualResponse = recurringPaymentService.createPn("interaction-id", "signature", request, "idempotency-key");

        assertEquals(expectedResponse, actualResponse);
    }

    @Test
    void createPj_ShouldReturnResponse() {
        PaymentsRequestPjDto request = PaymentsRequestPjDto.builder().build();
        PaymentsResponsePjDto expectedResponse = PaymentsResponsePjDto.builder().build();

        when(integrationService.createPj("interaction-id", "signature", request, "idempotency-key"))
                .thenReturn(expectedResponse);

        PaymentsResponsePjDto actualResponse = recurringPaymentService.createPj("interaction-id", "signature", request, "idempotency-key");

        assertEquals(expectedResponse, actualResponse);
    }

    @Test
    void get_ShouldReturnResponse() {
        RecurringPaymentDetailResponseDto expectedResponse = RecurringPaymentDetailResponseDto.builder().build();

        when(integrationService.get("PAY-123", "PJ","interaction-id", "signature"))
                .thenReturn(expectedResponse);

        RecurringPaymentDetailResponseDto actualResponse = recurringPaymentService.get("PAY-123", "PJ", "interaction-id", "signature");

        assertEquals(expectedResponse, actualResponse);
    }
}
