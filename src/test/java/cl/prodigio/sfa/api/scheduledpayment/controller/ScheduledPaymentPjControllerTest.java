package cl.prodigio.sfa.api.scheduledpayment.controller;

import cl.prodigio.sfa.api.scheduledpayment.dto.api.request.PaymentsRequestPjDto;
import cl.prodigio.sfa.api.scheduledpayment.dto.api.response.PaymentsResponsePjDto;
import cl.prodigio.sfa.api.scheduledpayment.service.core.ScheduledPaymentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ScheduledPaymentPjController.class)
class ScheduledPaymentPjControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ScheduledPaymentService scheduledPaymentService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void createScheduledPayment_ShouldReturnOk() throws Exception {
        PaymentsRequestPjDto request = PaymentsRequestPjDto.builder().build();
        PaymentsResponsePjDto response = PaymentsResponsePjDto.builder().build();

        when(scheduledPaymentService.createPj(eq("interaction-id"), eq("jws-signature"), any(PaymentsRequestPjDto.class), eq("idempotency-key")))
                .thenReturn(response);

        mockMvc.perform(post("/single-payments/v1/scheduled-payment/v1/PJ/scheduled-payments")
                        .header("x-fapi-interaction-id", "interaction-id")
                        .header("x-jws-signature", "jws-signature")
                        .header("x-idempotency-key", "idempotency-key")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk());
    }
}
