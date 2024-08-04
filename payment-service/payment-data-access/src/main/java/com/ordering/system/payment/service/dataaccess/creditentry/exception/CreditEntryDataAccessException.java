package com.ordering.system.payment.service.dataaccess.creditentry.exception;

public class CreditEntryDataAccessException extends RuntimeException {

    public CreditEntryDataAccessException(String message) {
        super(message);
    }

    public CreditEntryDataAccessException(String message, Throwable cause) {
        super(message, cause);
    }

}
