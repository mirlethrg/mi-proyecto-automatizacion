package com.mypolio.qa.paymentsystem.core.services.http;

/**
 * Interface for internal HTTP client services.
 * Stub implementation for portfolio demonstration.
 */
public interface HttpClientService {
    <T, R> R postInternal(HttpRequestDto<T, R> request);
    <T, R> R getInternal(HttpRequestDto<T, R> request);
}
