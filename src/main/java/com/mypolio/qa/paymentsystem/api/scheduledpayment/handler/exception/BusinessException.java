package com.mypolio.qa.paymentsystem.api.scheduledpayment.handler.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * Base exception for business/domain validation errors.
 */
@Getter
public class BusinessException extends RuntimeException {

    private final String code;
    private final HttpStatus status;

    public BusinessException(String code, String message) {
        this(code, message, HttpStatus.BAD_REQUEST);
    }

    public BusinessException(String code, String message, HttpStatus status) {
        super(message);
        this.code = code;
        this.status = status;
    }
}

