package com.mypolio.qa.paymentsystem.core.services.http;

import com.fasterxml.jackson.core.type.TypeReference;
import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpHeaders;
import java.time.Duration;

/**
 * Data Transfer Object for HTTP requests.
 * Stub implementation for portfolio demonstration.
 */
@Getter
@Builder
public class HttpRequestDto<T, R> {
    private String url;
    private HttpHeaders headers;
    private T body;
    private Duration timeout;
    private TypeReference<R> responseType;
    private String baseLog;
}
