package com.ordering.system.payment.service.domain.outbox.model;

import com.ordering.system.domain.valueobject.PaymentStatus;
import com.ordering.system.outbox.OutboxStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class OrderOutboxMessage {

    private UUID id;

    private UUID sagaId;

    private ZonedDateTime createdAt;

    private ZonedDateTime processedAt;

    private String type;

    private String payload;

    private PaymentStatus paymentStatus;

    @Setter
    private OutboxStatus outboxStatus;

    private int version;

}
