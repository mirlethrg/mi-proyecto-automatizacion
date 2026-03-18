package cl.prodigio.sfa.api.scheduledpayment.controller;

import cl.prodigio.sfa.api.scheduledpayment.dto.api.response.PaymentDetailResponseDto;
import cl.prodigio.sfa.api.scheduledpayment.service.core.ScheduledPaymentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ScheduledPaymentQueryController.class)
class ScheduledPaymentQueryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ScheduledPaymentService scheduledPaymentService;

    @Test
    void getScheduledPayment_ShouldReturnOk() throws Exception {
        PaymentDetailResponseDto response = PaymentDetailResponseDto.builder().build();

        when(scheduledPaymentService.get(eq("PAY-123"), eq("PN"), eq("interaction-id"), eq("jws-signature")))
                .thenReturn(response);

        mockMvc.perform(get("/scheduled-payments/v1/PN/scheduled-payments/PAY-123")
                        .header("x-fapi-interaction-id", "interaction-id")
                        .header("x-jws-signature", "jws-signature"))
                .andExpect(status().isOk());
    }
}
