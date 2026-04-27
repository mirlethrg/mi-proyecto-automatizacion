package com.mypolio.qa.paymentsystem.api.scheduledpayment.controller;

import com.mypolio.qa.paymentsystem.api.scheduledpayment.dto.api.recurringpayment.request.RecurringPaymentsRequestPjDto;
import com.mypolio.qa.paymentsystem.api.scheduledpayment.dto.api.recurringpayment.request.RecurringPaymentsRequestPnDto;
import com.mypolio.qa.paymentsystem.api.scheduledpayment.dto.api.recurringpayment.response.RecurringPaymentResponsePjDto;
import com.mypolio.qa.paymentsystem.api.scheduledpayment.dto.api.recurringpayment.response.RecurringPaymentsResponsePnDto;
import com.mypolio.qa.paymentsystem.api.scheduledpayment.dto.api.recurringpayment.response.RecurringPaymentDetailResponseDto;
import com.mypolio.qa.paymentsystem.api.scheduledpayment.service.core.RecurringPaymentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/recurring-payments/v1")
@RequiredArgsConstructor
public class RecurringPaymentController {

    private final RecurringPaymentService recurringPaymentService;

    @PostMapping("/PN/recurring-payments")
    public ResponseEntity<RecurringPaymentsResponsePnDto> createPn(
            @RequestHeader("x-fapi-interaction-id") String interactionId,
            @RequestHeader("x-jws-signature") String jwsSignature,
            @RequestHeader("x-idempotency-key") String idempotencyKey,
            @RequestBody RecurringPaymentsRequestPnDto request) {
        log.info("Received request to create PN recurring payment in API");
        return ResponseEntity.ok(recurringPaymentService.createPn(interactionId, jwsSignature, request, idempotencyKey));
    }

    @PostMapping("/PJ/recurring-payments")
    public ResponseEntity<RecurringPaymentResponsePjDto> createPj(
            @RequestHeader("x-fapi-interaction-id") String interactionId,
            @RequestHeader("x-jws-signature") String jwsSignature,
            @RequestHeader("x-idempotency-key") String idempotencyKey,
            @RequestBody RecurringPaymentsRequestPjDto request) {
        log.info("Received request to create PJ recurring payment in API");
        return ResponseEntity.ok(recurringPaymentService.createPj(interactionId, jwsSignature, request, idempotencyKey));
    }

    @GetMapping("/{participantType}/recurring-payments/{paymentId}")
    public ResponseEntity<RecurringPaymentDetailResponseDto> get(
            @PathVariable String paymentId,
            @PathVariable String participantType,
            @RequestHeader("x-fapi-interaction-id") String interactionId,
            @RequestHeader(value = "x-jws-signature", required = false) String jwsSignature) {
        log.info("Received request to query recurring payment for {}", paymentId);
        return ResponseEntity.ok(recurringPaymentService.get(paymentId, participantType, interactionId, jwsSignature));
    }
}

