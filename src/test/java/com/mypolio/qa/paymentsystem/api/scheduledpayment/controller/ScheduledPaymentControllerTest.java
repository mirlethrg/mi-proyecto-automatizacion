package com.mypolio.qa.paymentsystem.api.scheduledpayment.controller;

import com.mypolio.qa.paymentsystem.api.scheduledpayment.dto.api.request.ScheduledPaymentsRequestPjDto;
import com.mypolio.qa.paymentsystem.api.scheduledpayment.dto.api.request.ScheduledPaymentsRequestPnDto;
import com.mypolio.qa.paymentsystem.api.scheduledpayment.dto.api.response.ScheduledPaymentDetailResponseDto;
import com.mypolio.qa.paymentsystem.api.scheduledpayment.dto.api.response.ScheduledPaymentsResponsePjDto;
import com.mypolio.qa.paymentsystem.api.scheduledpayment.dto.api.response.ScheduledPaymentsResponsePnDto;
import com.mypolio.qa.paymentsystem.api.scheduledpayment.service.core.ScheduledPaymentService;
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

@WebMvcTest(ScheduledPaymentController.class)
class ScheduledPaymentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private ScheduledPaymentService scheduledPaymentService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void createPn_ShouldReturnOk() throws Exception {
        ScheduledPaymentsRequestPnDto request = ScheduledPaymentsRequestPnDto.builder().build();
        ScheduledPaymentsResponsePnDto response = ScheduledPaymentsResponsePnDto.builder().build();

        when(scheduledPaymentService.createPn(eq("interaction-id"), eq("jws-signature"), any(ScheduledPaymentsRequestPnDto.class), eq("idempotency-key")))
                .thenReturn(response);

        mockMvc.perform(post("/scheduled-payments/v1/PN/scheduled-payments")
                        .header("x-fapi-interaction-id", "interaction-id")
                        .header("x-jws-signature", "jws-signature")
                        .header("x-idempotency-key", "idempotency-key")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk());
    }

    @Test
    void createPj_ShouldReturnOk() throws Exception {
        ScheduledPaymentsRequestPjDto request = ScheduledPaymentsRequestPjDto.builder().build();
        ScheduledPaymentsResponsePjDto response = ScheduledPaymentsResponsePjDto.builder().build();

        when(scheduledPaymentService.createPj(eq("interaction-id"), eq("jws-signature"), any(ScheduledPaymentsRequestPjDto.class), eq("idempotency-key")))
                .thenReturn(response);

        mockMvc.perform(post("/scheduled-payments/v1/PJ/scheduled-payments")
                        .header("x-fapi-interaction-id", "interaction-id")
                        .header("x-jws-signature", "jws-signature")
                        .header("x-idempotency-key", "idempotency-key")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk());
    }

    @Test
    void get_ShouldReturnOk() throws Exception {
        ScheduledPaymentDetailResponseDto response = ScheduledPaymentDetailResponseDto.builder().build();

        when(scheduledPaymentService.get(eq("PAY-123"), eq("PN"), eq("interaction-id"), any()))
                .thenReturn(response);

        mockMvc.perform(get("/scheduled-payments/v1/PN/scheduled-payments/PAY-123")
                        .header("x-fapi-interaction-id", "interaction-id"))
                .andExpect(status().isOk());
    }
}

