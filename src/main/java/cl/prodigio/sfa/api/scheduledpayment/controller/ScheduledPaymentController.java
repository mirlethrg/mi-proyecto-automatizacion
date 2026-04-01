package cl.prodigio.sfa.api.scheduledpayment.controller;

import cl.prodigio.sfa.api.scheduledpayment.dto.api.request.PaymentsRequestPjDto;
import cl.prodigio.sfa.api.scheduledpayment.dto.api.request.PaymentsRequestPnDto;
import cl.prodigio.sfa.api.scheduledpayment.dto.api.response.PaymentDetailResponseDto;
import cl.prodigio.sfa.api.scheduledpayment.dto.api.response.PaymentsResponsePjDto;
import cl.prodigio.sfa.api.scheduledpayment.dto.api.response.PaymentsResponsePnDto;
import cl.prodigio.sfa.api.scheduledpayment.service.core.ScheduledPaymentService;
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
    public ResponseEntity<PaymentsResponsePnDto> createPn(
            @RequestHeader("x-fapi-interaction-id") String interactionId,
            @RequestHeader("x-jws-signature") String jwsSignature,
            @RequestHeader("x-idempotency-key") String idempotencyKey,
            @RequestBody PaymentsRequestPnDto request) {
        log.info("Received request to create PN scheduled payment in API");
        return ResponseEntity.ok(scheduledPaymentService.createPn(interactionId, jwsSignature, request, idempotencyKey));
    }

    @PostMapping("/PJ/scheduled-payments")
    public ResponseEntity<PaymentsResponsePjDto> createPj(
            @RequestHeader("x-fapi-interaction-id") String interactionId,
            @RequestHeader("x-jws-signature") String jwsSignature,
            @RequestHeader("x-idempotency-key") String idempotencyKey,
            @RequestBody PaymentsRequestPjDto request) {
        log.info("Received request to create PJ scheduled payment in API");
        return ResponseEntity.ok(scheduledPaymentService.createPj(interactionId, jwsSignature, request, idempotencyKey));
    }

    @GetMapping("/{participantType}/scheduled-payments/{paymentId}")
    public ResponseEntity<PaymentDetailResponseDto> get(
            @PathVariable String participantType,
            @PathVariable String paymentId,
            @RequestHeader("x-fapi-interaction-id") String interactionId,
            @RequestHeader(value = "x-jws-signature", required = false) String jwsSignature) {
        log.info("Received request to query scheduled payment for {} and id {} in API", participantType, paymentId);
        return ResponseEntity.ok(scheduledPaymentService.get(paymentId, participantType, interactionId, jwsSignature));
    }
}
