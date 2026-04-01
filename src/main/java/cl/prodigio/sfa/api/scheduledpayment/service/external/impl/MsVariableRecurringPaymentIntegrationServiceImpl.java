package cl.prodigio.sfa.api.scheduledpayment.service.external.impl;

import cl.prodigio.sfa.api.scheduledpayment.dto.api.variablerecurringpayment.request.PaymentsRequestPjDto;
import cl.prodigio.sfa.api.scheduledpayment.dto.api.variablerecurringpayment.request.PaymentsRequestPnDto;
import cl.prodigio.sfa.api.scheduledpayment.dto.api.variablerecurringpayment.response.PaymentsResponsePjDto;
import cl.prodigio.sfa.api.scheduledpayment.dto.api.variablerecurringpayment.response.PaymentsResponsePnDto;
import cl.prodigio.sfa.api.scheduledpayment.dto.api.variablerecurringpayment.response.VariableRecurringPaymentDetailResponseDto;
import cl.prodigio.sfa.api.scheduledpayment.service.external.MsVariableRecurringPaymentIntegrationService;
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
public class MsVariableRecurringPaymentIntegrationServiceImpl implements MsVariableRecurringPaymentIntegrationService {

    private final HttpClientService httpClientService;

    @Value("${ms.variable.recurring.payment.base.url}")
    private String baseUrl;

    @Value("${ms.timeout}")
    private int connectionTimeout;

    @Override
    public PaymentsResponsePnDto createPn(String interactionId, String jwsSignature, PaymentsRequestPnDto request, String idempotencyKey) {
        log.info("Forwarding PN variable recurring payment to MS with interactionId {} and idempotencyKey {}", interactionId, idempotencyKey);
        String url = baseUrl + "/PN/variable-recurring-payments";

        HttpHeaders headers = createHeaders(interactionId, jwsSignature, idempotencyKey);

        var req = HttpRequestDto.<PaymentsRequestPnDto, PaymentsResponsePnDto>builder()
                .url(url)
                .headers(headers)
                .body(request)
                .timeout(Duration.ofMillis(connectionTimeout))
                .responseType(new TypeReference<>() {
                })
                .baseLog("MsVariableRecurringPaymentIntegrationService.createPn")
                .build();

        return httpClientService.postInternal(req);
    }

    @Override
    public PaymentsResponsePjDto createPj(String interactionId, String jwsSignature, PaymentsRequestPjDto request, String idempotencyKey) {
        log.info("Forwarding PJ variable recurring payment to MS with interactionId {} and idempotencyKey {}", interactionId, idempotencyKey);
        String url = baseUrl + "/PJ/variable-recurring-payments";

        HttpHeaders headers = createHeaders(interactionId, jwsSignature, idempotencyKey);

        var req = HttpRequestDto.<PaymentsRequestPjDto, PaymentsResponsePjDto>builder()
                .url(url)
                .headers(headers)
                .body(request)
                .timeout(Duration.ofMillis(connectionTimeout))
                .responseType(new TypeReference<>() {
                })
                .baseLog("MsVariableRecurringPaymentIntegrationService.createPj")
                .build();

        return httpClientService.postInternal(req);
    }

    @Override
    public VariableRecurringPaymentDetailResponseDto get(String paymentId, String participantType, String interactionId, String jwsSignature) {
        log.info("Forwarding query for {} and participantType {} to MS", paymentId, participantType);
        String url = baseUrl + "/" + participantType + "/variable-recurring-payments/" + paymentId;

        HttpHeaders headers = createHeaders(interactionId, jwsSignature, null);

        var req = HttpRequestDto.<Void, VariableRecurringPaymentDetailResponseDto>builder()
                .url(url)
                .headers(headers)
                .timeout(Duration.ofMillis(connectionTimeout))
                .responseType(new TypeReference<>() {
                })
                .baseLog("MsVariableRecurringPaymentIntegrationService.getPaymentPJ")
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
