package com.mypolio.qa.paymentsystem.api.scheduledpayment.controller;

import com.mypolio.qa.paymentsystem.api.scheduledpayment.dto.api.variablerecurringpayment.request.VariablePaymentRequestPjDto;
import com.mypolio.qa.paymentsystem.api.scheduledpayment.dto.api.variablerecurringpayment.request.VariablePaymentRequestPnDto;
import com.mypolio.qa.paymentsystem.api.scheduledpayment.dto.api.variablerecurringpayment.response.VariablePaymentResponsePjDto;
import com.mypolio.qa.paymentsystem.api.scheduledpayment.dto.api.variablerecurringpayment.response.VariablePaymentResponsePnDto;
import com.mypolio.qa.paymentsystem.api.scheduledpayment.dto.api.variablerecurringpayment.response.VariableRecurringPaymentDetailResponseDto;
import com.mypolio.qa.paymentsystem.api.scheduledpayment.service.core.VariableRecurringPaymentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/variable-recurring-payments/v1")
@RequiredArgsConstructor
public class VariableRecurringPaymentController {

    private final VariableRecurringPaymentService variableRecurringPaymentService;

    @PostMapping("/PN/variable-recurring-payments")
    public ResponseEntity<VariablePaymentResponsePnDto> createPn(
            @RequestHeader("x-fapi-interaction-id") String interactionId,
            @RequestHeader("x-jws-signature") String jwsSignature,
            @RequestHeader("x-idempotency-key") String idempotencyKey,
            @RequestBody VariablePaymentRequestPnDto request) {
        log.info("Received request to create PN variable recurring payment in API");
        return ResponseEntity.ok(variableRecurringPaymentService.createPn(interactionId, jwsSignature, request, idempotencyKey));
    }

    @PostMapping("/PJ/variable-recurring-payments")
    public ResponseEntity<VariablePaymentResponsePjDto> createPj(
            @RequestHeader("x-fapi-interaction-id") String interactionId,
            @RequestHeader("x-jws-signature") String jwsSignature,
            @RequestHeader("x-idempotency-key") String idempotencyKey,
            @RequestBody VariablePaymentRequestPjDto request) {
        log.info("Received request to create PJ variable recurring payment in API");
        return ResponseEntity.ok(variableRecurringPaymentService.createPj(interactionId, jwsSignature, request, idempotencyKey));
    }

    @GetMapping("/{participantType}/variable-recurring-payments/{paymentId}")
    public ResponseEntity<VariableRecurringPaymentDetailResponseDto> get(
            @PathVariable String participantType,
            @PathVariable String paymentId,
            @RequestHeader("x-fapi-interaction-id") String interactionId,
            @RequestHeader(value = "x-jws-signature", required = false) String jwsSignature) {
        log.info("Received request to query variable recurring payment for {} and id {} in API", participantType, paymentId);
        return ResponseEntity.ok(variableRecurringPaymentService.get(paymentId, participantType, interactionId, jwsSignature));
    }
}

