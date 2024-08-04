package com.ordering.system.payment.service.domain.exception;

import com.ordering.system.domain.exception.DomainException;

public class PaymentAppServiceException extends DomainException {

    public PaymentAppServiceException(String message) {
        super(message);
    }

    public PaymentAppServiceException(String message, Throwable cause) {
        super(message, cause);
    }

}
