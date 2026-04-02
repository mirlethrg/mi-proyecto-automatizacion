package cl.prodigio.sfa.api.scheduledpayment.controller;

import cl.prodigio.sfa.api.scheduledpayment.dto.api.variablerecurringpayment.request.VariablePaymentRequestPjDto;
import cl.prodigio.sfa.api.scheduledpayment.dto.api.variablerecurringpayment.request.VariablePaymentRequestPnDto;
import cl.prodigio.sfa.api.scheduledpayment.dto.api.variablerecurringpayment.response.VariablePaymentResponsePjDto;
import cl.prodigio.sfa.api.scheduledpayment.dto.api.variablerecurringpayment.response.VariablePaymentResponsePnDto;
import cl.prodigio.sfa.api.scheduledpayment.dto.api.variablerecurringpayment.response.VariableRecurringPaymentDetailResponseDto;
import cl.prodigio.sfa.api.scheduledpayment.service.core.VariableRecurringPaymentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(VariableRecurringPaymentController.class)
class VariableRecurringPaymentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private VariableRecurringPaymentService variableRecurringPaymentService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void createPn_ShouldReturnOk() throws Exception {
        VariablePaymentRequestPnDto request = VariablePaymentRequestPnDto.builder().build();
        VariablePaymentResponsePnDto response = VariablePaymentResponsePnDto.builder().build();

        when(variableRecurringPaymentService.createPn(eq("interaction-id"), eq("jws-signature"), any(VariablePaymentRequestPnDto.class), eq("idempotency-key")))
                .thenReturn(response);

        mockMvc.perform(post("/variable-recurring-payments/v1/PN/variable-recurring-payments")
                        .header("x-fapi-interaction-id", "interaction-id")
                        .header("x-jws-signature", "jws-signature")
                        .header("x-idempotency-key", "idempotency-key")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk());
    }

    @Test
    void createPj_ShouldReturnOk() throws Exception {
        VariablePaymentRequestPjDto request = VariablePaymentRequestPjDto.builder().build();
        VariablePaymentResponsePjDto response = VariablePaymentResponsePjDto.builder().build();

        when(variableRecurringPaymentService.createPj(eq("interaction-id"), eq("jws-signature"), any(VariablePaymentRequestPjDto.class), eq("idempotency-key")))
                .thenReturn(response);

        mockMvc.perform(post("/variable-recurring-payments/v1/PJ/variable-recurring-payments")
                        .header("x-fapi-interaction-id", "interaction-id")
                        .header("x-jws-signature", "jws-signature")
                        .header("x-idempotency-key", "idempotency-key")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk());
    }

    @Test
    void get_ShouldReturnOk() throws Exception {
        VariableRecurringPaymentDetailResponseDto response = VariableRecurringPaymentDetailResponseDto.builder().build();

        when(variableRecurringPaymentService.get(eq("RPV-2025-0001"), eq("PN"), eq("interaction-id"), any()))
                .thenReturn(response);

        mockMvc.perform(get("/variable-recurring-payments/v1/PN/variable-recurring-payments/RPV-2025-0001")
                        .header("x-fapi-interaction-id", "interaction-id"))
                .andExpect(status().isOk());
    }
}
