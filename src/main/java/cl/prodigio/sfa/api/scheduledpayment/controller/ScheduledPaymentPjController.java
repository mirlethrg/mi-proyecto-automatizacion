package cl.prodigio.sfa.api.scheduledpayment.controller;

import cl.prodigio.sfa.api.scheduledpayment.dto.api.request.PaymentsRequestPjDto;
import cl.prodigio.sfa.api.scheduledpayment.dto.api.response.PaymentsResponsePjDto;
import cl.prodigio.sfa.api.scheduledpayment.service.core.ScheduledPaymentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/scheduled-payments/v1/PJ/scheduled-payments")
@RequiredArgsConstructor
public class ScheduledPaymentPjController {

    private final ScheduledPaymentService scheduledPaymentService;

    @PostMapping
    public ResponseEntity<PaymentsResponsePjDto> createScheduledPayment(
            @RequestHeader("x-fapi-interaction-id") String interactionId,
            @RequestHeader("x-jws-signature") String jwsSignature,
            @RequestHeader("x-idempotency-key") String idempotencyKey,
            @RequestBody PaymentsRequestPjDto request) {
        log.info("Received request to create PJ scheduled payment in API");
        return ResponseEntity.ok(scheduledPaymentService.createPj(interactionId, jwsSignature, request, idempotencyKey));
    }
}
