package com.mypolio.qa.paymentsystem.api.scheduledpayment.handler.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * Base exception for technical/platform failures that should be surfaced as API errors.
 */
@Getter
public class TechnicalException extends RuntimeException {

    private final String code;
    private final HttpStatus status;

    public TechnicalException(String code, String message) {
        this(code, message, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public TechnicalException(String code, String message, HttpStatus status) {
        super(message);
        this.code = code;
        this.status = status;
    }
}

