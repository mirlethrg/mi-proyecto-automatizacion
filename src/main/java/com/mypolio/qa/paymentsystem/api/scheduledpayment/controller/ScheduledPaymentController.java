package com.mypolio.qa.paymentsystem.api.scheduledpayment.controller;

import com.mypolio.qa.paymentsystem.api.scheduledpayment.dto.api.request.ScheduledPaymentsRequestPjDto;
import com.mypolio.qa.paymentsystem.api.scheduledpayment.dto.api.request.ScheduledPaymentsRequestPnDto;
import com.mypolio.qa.paymentsystem.api.scheduledpayment.dto.api.response.ScheduledPaymentDetailResponseDto;
import com.mypolio.qa.paymentsystem.api.scheduledpayment.dto.api.response.ScheduledPaymentsResponsePjDto;
import com.mypolio.qa.paymentsystem.api.scheduledpayment.dto.api.response.ScheduledPaymentsResponsePnDto;
import com.mypolio.qa.paymentsystem.api.scheduledpayment.service.core.ScheduledPaymentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/scheduled-payments/v1")
@RequiredArgsConstructor
public class ScheduledPaymentController {

    private final ScheduledPaymentService scheduledPaymentService;

    @PostMapping("/PN/scheduled-payments")
    public ResponseEntity<ScheduledPaymentsResponsePnDto> createPn(
            @RequestHeader("x-fapi-interaction-id") String interactionId,
            @RequestHeader("x-jws-signature") String jwsSignature,
            @RequestHeader("x-idempotency-key") String idempotencyKey,
            @RequestBody ScheduledPaymentsRequestPnDto request) {
        log.info("Received request to create PN scheduled payment in API");
        return ResponseEntity.ok(scheduledPaymentService.createPn(interactionId, jwsSignature, request, idempotencyKey));
    }

    @PostMapping("/PJ/scheduled-payments")
    public ResponseEntity<ScheduledPaymentsResponsePjDto> createPj(
            @RequestHeader("x-fapi-interaction-id") String interactionId,
            @RequestHeader("x-jws-signature") String jwsSignature,
            @RequestHeader("x-idempotency-key") String idempotencyKey,
            @RequestBody ScheduledPaymentsRequestPjDto request) {
        log.info("Received request to create PJ scheduled payment in API");
        return ResponseEntity.ok(scheduledPaymentService.createPj(interactionId, jwsSignature, request, idempotencyKey));
    }

    @GetMapping("/{participantType}/scheduled-payments/{paymentId}")
    public ResponseEntity<ScheduledPaymentDetailResponseDto> get(
            @PathVariable String participantType,
            @PathVariable String paymentId,
            @RequestHeader("x-fapi-interaction-id") String interactionId,
            @RequestHeader(value = "x-jws-signature", required = false) String jwsSignature) {
        log.info("Received request to query scheduled payment for {} and id {} in API", participantType, paymentId);
        return ResponseEntity.ok(scheduledPaymentService.get(paymentId, participantType, interactionId, jwsSignature));
    }
}

