package cl.prodigio.sfa.api.scheduledpayment.controller;

import cl.prodigio.sfa.api.scheduledpayment.dto.api.recurringpayment.request.PaymentsRequestPjDto;
import cl.prodigio.sfa.api.scheduledpayment.dto.api.recurringpayment.request.PaymentsRequestPnDto;
import cl.prodigio.sfa.api.scheduledpayment.dto.api.recurringpayment.response.PaymentsResponsePjDto;
import cl.prodigio.sfa.api.scheduledpayment.dto.api.recurringpayment.response.PaymentsResponsePnDto;
import cl.prodigio.sfa.api.scheduledpayment.dto.api.recurringpayment.response.RecurringPaymentDetailResponseDto;
import cl.prodigio.sfa.api.scheduledpayment.service.core.RecurringPaymentService;
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
    public ResponseEntity<PaymentsResponsePnDto> createPn(
            @RequestHeader("x-fapi-interaction-id") String interactionId,
            @RequestHeader("x-jws-signature") String jwsSignature,
            @RequestHeader("x-idempotency-key") String idempotencyKey,
            @RequestBody PaymentsRequestPnDto request) {
        log.info("Received request to create PN recurring payment in API");
        return ResponseEntity.ok(recurringPaymentService.createPn(interactionId, jwsSignature, request, idempotencyKey));
    }

    @PostMapping("/PJ/recurring-payments")
    public ResponseEntity<PaymentsResponsePjDto> createPj(
            @RequestHeader("x-fapi-interaction-id") String interactionId,
            @RequestHeader("x-jws-signature") String jwsSignature,
            @RequestHeader("x-idempotency-key") String idempotencyKey,
            @RequestBody PaymentsRequestPjDto request) {
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
