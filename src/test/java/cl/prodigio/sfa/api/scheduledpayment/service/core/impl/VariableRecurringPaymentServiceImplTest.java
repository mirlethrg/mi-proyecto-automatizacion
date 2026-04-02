package cl.prodigio.sfa.api.scheduledpayment.service.core.impl;

import cl.prodigio.sfa.api.scheduledpayment.dto.api.variablerecurringpayment.request.VariablePaymentRequestPjDto;
import cl.prodigio.sfa.api.scheduledpayment.dto.api.variablerecurringpayment.request.VariablePaymentRequestPnDto;
import cl.prodigio.sfa.api.scheduledpayment.dto.api.variablerecurringpayment.response.VariablePaymentResponsePjDto;
import cl.prodigio.sfa.api.scheduledpayment.dto.api.variablerecurringpayment.response.VariablePaymentResponsePnDto;
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
        VariablePaymentRequestPnDto request = VariablePaymentRequestPnDto.builder().build();
        VariablePaymentResponsePnDto expectedResponse = VariablePaymentResponsePnDto.builder().build();

        when(integrationService.createVariableRecurringPn("interaction-id", "signature", request, "idempotency-key"))
                .thenReturn(expectedResponse);

        VariablePaymentResponsePnDto actualResponse = variableRecurringPaymentService.createPn("interaction-id", "signature", request, "idempotency-key");

        assertEquals(expectedResponse, actualResponse);
    }

    @Test
    void createPj_ShouldReturnResponse() {
        VariablePaymentRequestPjDto request = VariablePaymentRequestPjDto.builder().build();
        VariablePaymentResponsePjDto expectedResponse = VariablePaymentResponsePjDto.builder().build();

        when(integrationService.createVariableRecurringPj("interaction-id", "signature", request, "idempotency-key"))
                .thenReturn(expectedResponse);

        VariablePaymentResponsePjDto actualResponse = variableRecurringPaymentService.createPj("interaction-id", "signature", request, "idempotency-key");

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
