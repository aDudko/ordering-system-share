package com.ordering.system.order.service.domain.dto.message;

import com.ordering.system.domain.valueobject.PaymentStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

/**
 * This will hold the response that return from the payment service to the order service
 * */

@Getter
@Builder
@AllArgsConstructor
public class PaymentResponse {

    private String id;

    // Use a sagaId in the messages between the services
    private String sagaId;

    private String orderId;

    private String paymentId;

    private String customerId;

    private BigDecimal price;

    private Instant createdAt;

    private PaymentStatus paymentStatus;

    private List<String> failureMessages;

}
