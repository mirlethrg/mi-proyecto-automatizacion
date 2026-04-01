package cl.prodigio.sfa.api.scheduledpayment.service.external.impl;

import cl.prodigio.sfa.core.services.http.HttpClientService;
import org.springframework.beans.factory.annotation.Value;

public abstract class AbstractMsIntegrationService {

    protected final HttpClientService httpClientService;

    @Value("${ms.timeout:5000}")
    protected int connectionTimeout;

    protected AbstractMsIntegrationService(HttpClientService httpClientService) {
        this.httpClientService = httpClientService;
    }
}
