package com.ordering.system.restaurant.service.dataaccess.restaurant.outbox.exception;

public class OrderOutboxNotFoundException extends RuntimeException {

    public OrderOutboxNotFoundException(String message) {
        super(message);
    }

    public OrderOutboxNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

}
