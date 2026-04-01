package cl.prodigio.sfa.api.scheduledpayment.service.external.impl;

import cl.prodigio.sfa.api.scheduledpayment.dto.api.recurringpayment.request.PaymentsRequestPjDto;
import cl.prodigio.sfa.api.scheduledpayment.dto.api.recurringpayment.request.PaymentsRequestPnDto;
import cl.prodigio.sfa.api.scheduledpayment.dto.api.recurringpayment.response.PaymentsResponsePjDto;
import cl.prodigio.sfa.api.scheduledpayment.dto.api.recurringpayment.response.PaymentsResponsePnDto;
import cl.prodigio.sfa.api.scheduledpayment.dto.api.recurringpayment.response.RecurringPaymentDetailResponseDto;
import cl.prodigio.sfa.api.scheduledpayment.service.external.MsRecurringPaymentIntegrationService;
import cl.prodigio.sfa.core.services.http.HttpClientService;
import cl.prodigio.sfa.core.services.http.HttpRequestDto;
import com.fasterxml.jackson.core.type.TypeReference;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Slf4j
@Service
@RequiredArgsConstructor
public class MsRecurringPaymentIntegrationServiceImpl implements MsRecurringPaymentIntegrationService {

    private final HttpClientService httpClientService;

    @Value("${ms.recurring.payment.base.url}")
    private String baseUrl;

    @Value("${ms.timeout}")
    private int connectionTimeout;

    @Override
    public PaymentsResponsePnDto createPn(String interactionId, String jwsSignature, PaymentsRequestPnDto request, String idempotencyKey) {
        log.info("Forwarding PN recurring payment to MS with interactionId {} and idempotencyKey {}", interactionId, idempotencyKey);
        String url = baseUrl + "/PN/recurring-payments";

        HttpHeaders headers = createHeaders(interactionId, jwsSignature, idempotencyKey);

        var req = HttpRequestDto.<PaymentsRequestPnDto, PaymentsResponsePnDto>builder()
                .url(url)
                .headers(headers)
                .body(request)
                .timeout(Duration.ofMillis(connectionTimeout))
                .responseType(new TypeReference<>() {
                })
                .baseLog("MsRecurringPaymentIntegrationService.createPn")
                .build();

        return httpClientService.postInternal(req);
    }

    @Override
    public PaymentsResponsePjDto createPj(String interactionId, String jwsSignature, PaymentsRequestPjDto request, String idempotencyKey) {
        log.info("Forwarding PJ recurring payment to MS with interactionId {} and idempotencyKey {}", interactionId, idempotencyKey);
        String url = baseUrl + "/PJ/recurring-payments";

        HttpHeaders headers = createHeaders(interactionId, jwsSignature, idempotencyKey);

        var req = HttpRequestDto.<PaymentsRequestPjDto, PaymentsResponsePjDto>builder()
                .url(url)
                .headers(headers)
                .body(request)
                .timeout(Duration.ofMillis(connectionTimeout))
                .responseType(new TypeReference<>() {
                })
                .baseLog("MsRecurringPaymentIntegrationService.createPj")
                .build();

        return httpClientService.postInternal(req);
    }

    @Override
    public RecurringPaymentDetailResponseDto get(String paymentId, String participantType, String interactionId, String jwsSignature) {
        log.info("Forwarding query for payment {} MS", paymentId);
        String url = baseUrl + "/" + participantType + "/recurring-payments/" + paymentId;

        HttpHeaders headers = createHeaders(interactionId, jwsSignature, null);

        var req = HttpRequestDto.<Void, RecurringPaymentDetailResponseDto>builder()
                .url(url)
                .headers(headers)
                .timeout(Duration.ofMillis(connectionTimeout))
                .responseType(new TypeReference<>() {
                })
                .baseLog("MsRecurringPaymentIntegrationService.get")
                .build();

        return httpClientService.getInternal(req);
    }

    private HttpHeaders createHeaders(String interactionId, String jwsSignature, String idempotencyKey) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("x-fapi-interaction-id", interactionId);
        if (jwsSignature != null) {
            headers.set("x-jws-signature", jwsSignature);
        }
        if (idempotencyKey != null) {
            headers.set("x-idempotency-key", idempotencyKey);
        }
        headers.set("Accept", "application/json");
        headers.set("Content-Type", "application/json");
        return headers;
    }
}
