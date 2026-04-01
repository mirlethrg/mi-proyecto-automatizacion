package cl.prodigio.sfa.api.scheduledpayment.service.external.impl;

import cl.prodigio.sfa.api.scheduledpayment.dto.api.variablerecurringpayment.request.PaymentsRequestPjDto;
import cl.prodigio.sfa.api.scheduledpayment.dto.api.variablerecurringpayment.request.PaymentsRequestPnDto;
import cl.prodigio.sfa.api.scheduledpayment.dto.api.variablerecurringpayment.response.PaymentsResponsePjDto;
import cl.prodigio.sfa.api.scheduledpayment.dto.api.variablerecurringpayment.response.PaymentsResponsePnDto;
import cl.prodigio.sfa.api.scheduledpayment.dto.api.variablerecurringpayment.response.VariableRecurringPaymentDetailResponseDto;
import cl.prodigio.sfa.api.scheduledpayment.service.external.MsVariableRecurringPaymentIntegrationService;
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
public class MsVariableRecurringPaymentIntegrationServiceImpl extends AbstractMsIntegrationService
        implements MsVariableRecurringPaymentIntegrationService {

    @Value("${ms.variable.recurring.payment.base.url}")
    private String baseUrl;

    public MsVariableRecurringPaymentIntegrationServiceImpl(HttpClientService httpClientService) {
        super(httpClientService);
    }

    @Override
    public PaymentsResponsePnDto createVariableRecurringPn(String interactionId, String jwsSignature, PaymentsRequestPnDto request, String idempotencyKey) {
        log.info("Forwarding PN variable recurring payment to MS with interactionId {} and idempotencyKey {}", interactionId, idempotencyKey);
        String url = baseUrl + "/PN/variable-recurring-payments";

        var req = HttpRequestDto.<PaymentsRequestPnDto, PaymentsResponsePnDto>builder()
                .url(url)
                .headers(FapiHeadersUtil.build(interactionId, jwsSignature, idempotencyKey))
                .body(request)
                .timeout(Duration.ofMillis(connectionTimeout))
                .responseType(new TypeReference<>() {
                })
                .baseLog("MsVariableRecurringPaymentIntegrationService.createVariableRecurringPn")
                .build();

        return httpClientService.postInternal(req);
    }

    @Override
    public PaymentsResponsePjDto createVariableRecurringPj(String interactionId, String jwsSignature, PaymentsRequestPjDto request, String idempotencyKey) {
        log.info("Forwarding PJ variable recurring payment to MS with interactionId {} and idempotencyKey {}", interactionId, idempotencyKey);
        String url = baseUrl + "/PJ/variable-recurring-payments";

        var req = HttpRequestDto.<PaymentsRequestPjDto, PaymentsResponsePjDto>builder()
                .url(url)
                .headers(FapiHeadersUtil.build(interactionId, jwsSignature, idempotencyKey))
                .body(request)
                .timeout(Duration.ofMillis(connectionTimeout))
                .responseType(new TypeReference<>() {
                })
                .baseLog("MsVariableRecurringPaymentIntegrationService.createVariableRecurringPj")
                .build();

        return httpClientService.postInternal(req);
    }

    @Override
    public VariableRecurringPaymentDetailResponseDto getVariableRecurringPayment(String paymentId, String participantType, String interactionId, String jwsSignature) {
        log.info("Forwarding query for {} and participantType {} to MS", paymentId, participantType);
        String url = baseUrl + "/" + participantType + "/variable-recurring-payments/" + paymentId;

        var req = HttpRequestDto.<Void, VariableRecurringPaymentDetailResponseDto>builder()
                .url(url)
                .headers(FapiHeadersUtil.build(interactionId, jwsSignature, null))
                .timeout(Duration.ofMillis(connectionTimeout))
                .responseType(new TypeReference<>() {
                })
                .baseLog("MsVariableRecurringPaymentIntegrationService.getVariableRecurringPayment")
                .build();

        return httpClientService.getInternal(req);
    }
}
