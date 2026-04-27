package com.mypolio.qa.paymentsystem.api.scheduledpayment.service.external.impl;

import com.mypolio.qa.paymentsystem.api.scheduledpayment.dto.api.recurringpayment.request.RecurringPaymentsRequestPjDto;
import com.mypolio.qa.paymentsystem.api.scheduledpayment.dto.api.recurringpayment.request.RecurringPaymentsRequestPnDto;
import com.mypolio.qa.paymentsystem.api.scheduledpayment.dto.api.recurringpayment.response.RecurringPaymentResponsePjDto;
import com.mypolio.qa.paymentsystem.api.scheduledpayment.dto.api.recurringpayment.response.RecurringPaymentsResponsePnDto;
import com.mypolio.qa.paymentsystem.api.scheduledpayment.dto.api.recurringpayment.response.RecurringPaymentDetailResponseDto;
import com.mypolio.qa.paymentsystem.api.scheduledpayment.service.external.MsRecurringPaymentIntegrationService;
import com.mypolio.qa.paymentsystem.api.scheduledpayment.util.FapiHeadersUtil;
import com.mypolio.qa.paymentsystem.core.services.http.HttpClientService;
import com.mypolio.qa.paymentsystem.core.services.http.HttpRequestDto;
import com.fasterxml.jackson.core.type.TypeReference;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Slf4j
@Service
public class MsRecurringPaymentIntegrationServiceImpl extends AbstractMsIntegrationService
        implements MsRecurringPaymentIntegrationService {

    @Value("${ms.recurring.payment.base.url}")
    private String baseUrl;

    public MsRecurringPaymentIntegrationServiceImpl(HttpClientService httpClientService) {
        super(httpClientService);
    }

    @Override
    public RecurringPaymentsResponsePnDto createRecurringPn(String interactionId, String jwsSignature, RecurringPaymentsRequestPnDto request, String idempotencyKey) {
        log.info("Forwarding PN recurring payment to MS with interactionId {} and idempotencyKey {}", interactionId, idempotencyKey);
        String url = baseUrl + "/PN/recurring-payments";

        var req = HttpRequestDto.<RecurringPaymentsRequestPnDto, RecurringPaymentsResponsePnDto>builder()
                .url(url)
                .headers(FapiHeadersUtil.build(interactionId, jwsSignature, idempotencyKey))
                .body(request)
                .timeout(Duration.ofMillis(connectionTimeout))
                .responseType(new TypeReference<>() {
                })
                .baseLog("MsRecurringPaymentIntegrationService.createRecurringPn")
                .build();

        return httpClientService.postInternal(req);
    }

    @Override
    public RecurringPaymentResponsePjDto createRecurringPj(String interactionId, String jwsSignature, RecurringPaymentsRequestPjDto request, String idempotencyKey) {
        log.info("Forwarding PJ recurring payment to MS with interactionId {} and idempotencyKey {}", interactionId, idempotencyKey);
        String url = baseUrl + "/PJ/recurring-payments";

        var req = HttpRequestDto.<RecurringPaymentsRequestPjDto, RecurringPaymentResponsePjDto>builder()
                .url(url)
                .headers(FapiHeadersUtil.build(interactionId, jwsSignature, idempotencyKey))
                .body(request)
                .timeout(Duration.ofMillis(connectionTimeout))
                .responseType(new TypeReference<>() {
                })
                .baseLog("MsRecurringPaymentIntegrationService.createRecurringPj")
                .build();

        return httpClientService.postInternal(req);
    }

    @Override
    public RecurringPaymentDetailResponseDto getRecurringPayment(String paymentId, String participantType, String interactionId, String jwsSignature) {
        log.info("Forwarding query for payment {} to MS", paymentId);
        String url = baseUrl + "/" + participantType + "/recurring-payments/" + paymentId;

        var req = HttpRequestDto.<Void, RecurringPaymentDetailResponseDto>builder()
                .url(url)
                .headers(FapiHeadersUtil.build(interactionId, jwsSignature, null))
                .timeout(Duration.ofMillis(connectionTimeout))
                .responseType(new TypeReference<>() {
                })
                .baseLog("MsRecurringPaymentIntegrationService.getRecurringPayment")
                .build();

        return httpClientService.getInternal(req);
    }
}

