package cl.prodigio.sfa.api.scheduledpayment.controller;

import cl.prodigio.sfa.api.scheduledpayment.dto.api.response.PaymentDetailResponseDto;
import cl.prodigio.sfa.api.scheduledpayment.service.core.ScheduledPaymentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/scheduled-payments/v1")
@RequiredArgsConstructor
public class ScheduledPaymentQueryController {

    private final ScheduledPaymentService scheduledPaymentService;

    @GetMapping("/{participantType}/scheduled-payments/{paymentId}")
    public ResponseEntity<PaymentDetailResponseDto> getScheduledPayment(
            @PathVariable String participantType,
            @PathVariable String paymentId,
            @RequestHeader("x-fapi-interaction-id") String interactionId,
            @RequestHeader(value = "x-jws-signature", required = false) String jwsSignature) {
        log.info("Received request to query scheduled payment for {} and id {} in API", participantType, paymentId);
        return ResponseEntity.ok(scheduledPaymentService.get(paymentId, participantType, interactionId, jwsSignature));
    }
}
