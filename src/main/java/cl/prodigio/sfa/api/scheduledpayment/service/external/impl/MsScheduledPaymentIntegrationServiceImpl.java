package cl.prodigio.sfa.api.scheduledpayment.service.external.impl;

import cl.prodigio.sfa.api.scheduledpayment.dto.api.request.ScheduledPaymentsRequestPjDto;
import cl.prodigio.sfa.api.scheduledpayment.dto.api.request.ScheduledPaymentsRequestPnDto;
import cl.prodigio.sfa.api.scheduledpayment.dto.api.response.ScheduledPaymentDetailResponseDto;
import cl.prodigio.sfa.api.scheduledpayment.dto.api.response.ScheduledPaymentsResponsePjDto;
import cl.prodigio.sfa.api.scheduledpayment.dto.api.response.ScheduledPaymentsResponsePnDto;
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
    public ScheduledPaymentsResponsePnDto createScheduledPn(String interactionId, String jwsSignature, ScheduledPaymentsRequestPnDto request, String idempotencyKey) {
        log.info("Forwarding PN scheduled payment to MS with interactionId {} and idempotencyKey {}", interactionId, idempotencyKey);
        String url = baseUrl + "/PN/scheduled-payments";

        var req = HttpRequestDto.<ScheduledPaymentsRequestPnDto, ScheduledPaymentsResponsePnDto>builder()
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
    public ScheduledPaymentsResponsePjDto createScheduledPj(String interactionId, String jwsSignature, ScheduledPaymentsRequestPjDto request, String idempotencyKey) {
        log.info("Forwarding PJ scheduled payment to MS with interactionId {} and idempotencyKey {}", interactionId, idempotencyKey);
        String url = baseUrl + "/PJ/scheduled-payments";

        var req = HttpRequestDto.<ScheduledPaymentsRequestPjDto, ScheduledPaymentsResponsePjDto>builder()
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
    public ScheduledPaymentDetailResponseDto getScheduledPayment(String paymentId, String participantType, String interactionId, String jwsSignature) {
        log.info("Forwarding query for {} and participantType {} to MS", paymentId, participantType);
        String url = baseUrl + "/" + participantType + "/scheduled-payments/" + paymentId;

        var req = HttpRequestDto.<Void, ScheduledPaymentDetailResponseDto>builder()
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
