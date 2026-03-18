package cl.prodigio.sfa.api.scheduledpayment.controller;

import cl.prodigio.sfa.api.scheduledpayment.dto.api.request.PaymentsRequestPnDto;
import cl.prodigio.sfa.api.scheduledpayment.dto.api.response.PaymentsResponsePnDto;
import cl.prodigio.sfa.api.scheduledpayment.service.core.ScheduledPaymentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/scheduled-payments/v1/PN/scheduled-payments")
@RequiredArgsConstructor
public class ScheduledPaymentPnController {

    private final ScheduledPaymentService scheduledPaymentService;

    @PostMapping
    public ResponseEntity<PaymentsResponsePnDto> createScheduledPayment(
            @RequestHeader("x-fapi-interaction-id") String interactionId,
            @RequestHeader("x-jws-signature") String jwsSignature,
            @RequestHeader("x-idempotency-key") String idempotencyKey,
            @RequestBody PaymentsRequestPnDto request) {
        log.info("Received request to create PN scheduled payment in API");
        return ResponseEntity.ok(scheduledPaymentService.createPn(interactionId, jwsSignature, request, idempotencyKey));
    }
}
