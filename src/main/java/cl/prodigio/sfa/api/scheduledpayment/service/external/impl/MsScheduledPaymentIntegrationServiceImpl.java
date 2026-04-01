package cl.prodigio.sfa.api.scheduledpayment.service.external.impl;

import cl.prodigio.sfa.api.scheduledpayment.dto.api.request.PaymentsRequestPjDto;
import cl.prodigio.sfa.api.scheduledpayment.dto.api.request.PaymentsRequestPnDto;
import cl.prodigio.sfa.api.scheduledpayment.dto.api.response.PaymentDetailResponseDto;
import cl.prodigio.sfa.api.scheduledpayment.dto.api.response.PaymentsResponsePjDto;
import cl.prodigio.sfa.api.scheduledpayment.dto.api.response.PaymentsResponsePnDto;
import cl.prodigio.sfa.api.scheduledpayment.service.external.MsScheduledPaymentIntegrationService;
import cl.prodigio.sfa.api.scheduledpayment.util.FapiHeadersUtil;
import cl.prodigio.sfa.core.services.http.HttpClientService;
import cl.prodigio.sfa.core.services.http.HttpRequestDto;
import com.fasterxml.jackson.core.type.TypeReference;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Slf4j
@Service
public class MsScheduledPaymentIntegrationServiceImpl extends AbstractMsIntegrationService
        implements MsScheduledPaymentIntegrationService {

    @Value("${ms.scheduled.payment.base.url}")
    private String baseUrl;

    public MsScheduledPaymentIntegrationServiceImpl(HttpClientService httpClientService) {
        super(httpClientService);
    }

    @Override
    public PaymentsResponsePnDto createScheduledPn(String interactionId, String jwsSignature, PaymentsRequestPnDto request, String idempotencyKey) {
        log.info("Forwarding PN scheduled payment to MS with interactionId {} and idempotencyKey {}", interactionId, idempotencyKey);
        String url = baseUrl + "/PN/scheduled-payments";

        var req = HttpRequestDto.<PaymentsRequestPnDto, PaymentsResponsePnDto>builder()
                .url(url)
                .headers(FapiHeadersUtil.build(interactionId, jwsSignature, idempotencyKey))
                .body(request)
                .timeout(Duration.ofMillis(connectionTimeout))
                .responseType(new TypeReference<>() {
                })
                .baseLog("MsScheduledPaymentIntegrationService.createScheduledPn")
                .build();

        return httpClientService.postInternal(req);
    }

    @Override
    public PaymentsResponsePjDto createScheduledPj(String interactionId, String jwsSignature, PaymentsRequestPjDto request, String idempotencyKey) {
        log.info("Forwarding PJ scheduled payment to MS with interactionId {} and idempotencyKey {}", interactionId, idempotencyKey);
        String url = baseUrl + "/PJ/scheduled-payments";

        var req = HttpRequestDto.<PaymentsRequestPjDto, PaymentsResponsePjDto>builder()
                .url(url)
                .headers(FapiHeadersUtil.build(interactionId, jwsSignature, idempotencyKey))
                .body(request)
                .timeout(Duration.ofMillis(connectionTimeout))
                .responseType(new TypeReference<>() {
                })
                .baseLog("MsScheduledPaymentIntegrationService.createScheduledPj")
                .build();

        return httpClientService.postInternal(req);
    }

    @Override
    public PaymentDetailResponseDto getScheduledPayment(String paymentId, String participantType, String interactionId, String jwsSignature) {
        log.info("Forwarding query for {} and participantType {} to MS", paymentId, participantType);
        String url = baseUrl + "/" + participantType + "/scheduled-payments/" + paymentId;

        var req = HttpRequestDto.<Void, PaymentDetailResponseDto>builder()
                .url(url)
                .headers(FapiHeadersUtil.build(interactionId, jwsSignature, null))
                .timeout(Duration.ofMillis(connectionTimeout))
                .responseType(new TypeReference<>() {
                })
                .baseLog("MsScheduledPaymentIntegrationService.getScheduledPayment")
                .build();

        return httpClientService.getInternal(req);
    }
}
