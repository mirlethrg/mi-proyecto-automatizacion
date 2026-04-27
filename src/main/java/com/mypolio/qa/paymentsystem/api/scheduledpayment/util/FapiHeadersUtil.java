package com.mypolio.qa.paymentsystem.api.scheduledpayment.util;

import org.springframework.http.HttpHeaders;

public class FapiHeadersUtil {

    private FapiHeadersUtil() {}

    public static HttpHeaders build(String interactionId, String jwsSignature, String idempotencyKey) {
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

