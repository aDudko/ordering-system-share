package com.ordering.system.order.service.dataaccess.outbox.restaurantapproval.exception;

public class ApprovalOutboxNotFoundException extends RuntimeException {

    public ApprovalOutboxNotFoundException(String message) {
        super(message);
    }

    public ApprovalOutboxNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

}
