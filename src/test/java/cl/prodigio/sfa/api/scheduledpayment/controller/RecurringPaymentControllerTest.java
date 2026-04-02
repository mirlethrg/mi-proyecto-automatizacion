package cl.prodigio.sfa.api.scheduledpayment.controller;

import cl.prodigio.sfa.api.scheduledpayment.dto.api.recurringpayment.request.RecurringPaymentsRequestPjDto;
import cl.prodigio.sfa.api.scheduledpayment.dto.api.recurringpayment.request.RecurringPaymentsRequestPnDto;
import cl.prodigio.sfa.api.scheduledpayment.dto.api.recurringpayment.response.RecurringPaymentResponsePjDto;
import cl.prodigio.sfa.api.scheduledpayment.dto.api.recurringpayment.response.RecurringPaymentsResponsePnDto;
import cl.prodigio.sfa.api.scheduledpayment.dto.api.recurringpayment.response.RecurringPaymentDetailResponseDto;
import cl.prodigio.sfa.api.scheduledpayment.service.core.RecurringPaymentService;
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

@WebMvcTest(RecurringPaymentController.class)
class RecurringPaymentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private RecurringPaymentService recurringPaymentService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void createPn_ShouldReturnOk() throws Exception {
        RecurringPaymentsRequestPnDto request = RecurringPaymentsRequestPnDto.builder().build();
        RecurringPaymentsResponsePnDto response = RecurringPaymentsResponsePnDto.builder().build();

        when(recurringPaymentService.createPn(eq("interaction-id"), eq("jws-signature"), any(RecurringPaymentsRequestPnDto.class), eq("idempotency-key")))
                .thenReturn(response);

        mockMvc.perform(post("/recurring-payments/v1/PN/recurring-payments")
                        .header("x-fapi-interaction-id", "interaction-id")
                        .header("x-jws-signature", "jws-signature")
                        .header("x-idempotency-key", "idempotency-key")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk());
    }

    @Test
    void createPj_ShouldReturnOk() throws Exception {
        RecurringPaymentsRequestPjDto request = RecurringPaymentsRequestPjDto.builder().build();
        RecurringPaymentResponsePjDto response = RecurringPaymentResponsePjDto.builder().build();

        when(recurringPaymentService.createPj(eq("interaction-id"), eq("jws-signature"), any(RecurringPaymentsRequestPjDto.class), eq("idempotency-key")))
                .thenReturn(response);

        mockMvc.perform(post("/recurring-payments/v1/PJ/recurring-payments")
                        .header("x-fapi-interaction-id", "interaction-id")
                        .header("x-jws-signature", "jws-signature")
                        .header("x-idempotency-key", "idempotency-key")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk());
    }

    @Test
    void get_ShouldReturnOk() throws Exception {
        RecurringPaymentDetailResponseDto response = RecurringPaymentDetailResponseDto.builder().build();

        when(recurringPaymentService.get(eq("RP-2025-0001"), eq("PN"), eq("interaction-id"), any()))
                .thenReturn(response);

        mockMvc.perform(get("/recurring-payments/v1/PN/recurring-payments/RP-2025-0001")
                        .header("x-fapi-interaction-id", "interaction-id"))
                .andExpect(status().isOk());
    }
}
