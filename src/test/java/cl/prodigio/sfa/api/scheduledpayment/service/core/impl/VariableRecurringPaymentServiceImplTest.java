package cl.prodigio.sfa.api.scheduledpayment.service.core.impl;

import cl.prodigio.sfa.api.scheduledpayment.dto.api.variablerecurringpayment.request.PaymentsRequestPjDto;
import cl.prodigio.sfa.api.scheduledpayment.dto.api.variablerecurringpayment.request.PaymentsRequestPnDto;
import cl.prodigio.sfa.api.scheduledpayment.dto.api.variablerecurringpayment.response.PaymentsResponsePjDto;
import cl.prodigio.sfa.api.scheduledpayment.dto.api.variablerecurringpayment.response.PaymentsResponsePnDto;
import cl.prodigio.sfa.api.scheduledpayment.dto.api.variablerecurringpayment.response.VariableRecurringPaymentDetailResponseDto;
import cl.prodigio.sfa.api.scheduledpayment.service.external.MsVariableRecurringPaymentIntegrationService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class VariableRecurringPaymentServiceImplTest {

    @Mock
    private MsVariableRecurringPaymentIntegrationService integrationService;

    @InjectMocks
    private VariableRecurringPaymentServiceImpl variableRecurringPaymentService;

    @Test
    void createPn_ShouldReturnResponse() {
        PaymentsRequestPnDto request = PaymentsRequestPnDto.builder().build();
        PaymentsResponsePnDto expectedResponse = PaymentsResponsePnDto.builder().build();

        when(integrationService.createVariableRecurringPn("interaction-id", "signature", request, "idempotency-key"))
                .thenReturn(expectedResponse);

        PaymentsResponsePnDto actualResponse = variableRecurringPaymentService.createPn("interaction-id", "signature", request, "idempotency-key");

        assertEquals(expectedResponse, actualResponse);
    }

    @Test
    void createPj_ShouldReturnResponse() {
        PaymentsRequestPjDto request = PaymentsRequestPjDto.builder().build();
        PaymentsResponsePjDto expectedResponse = PaymentsResponsePjDto.builder().build();

        when(integrationService.createVariableRecurringPj("interaction-id", "signature", request, "idempotency-key"))
                .thenReturn(expectedResponse);

        PaymentsResponsePjDto actualResponse = variableRecurringPaymentService.createPj("interaction-id", "signature", request, "idempotency-key");

        assertEquals(expectedResponse, actualResponse);
    }

    @Test
    void get_ShouldReturnResponse() {
        VariableRecurringPaymentDetailResponseDto expectedResponse = VariableRecurringPaymentDetailResponseDto.builder().build();

        when(integrationService.getVariableRecurringPayment("PAY-123", "PN", "interaction-id", "signature"))
                .thenReturn(expectedResponse);

        VariableRecurringPaymentDetailResponseDto actualResponse = variableRecurringPaymentService.get("PAY-123", "PN", "interaction-id", "signature");

        assertEquals(expectedResponse, actualResponse);
    }
}
