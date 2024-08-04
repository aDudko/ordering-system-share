package com.ordering.system.order.service.dataaccess.outbox.payment.entity;

import com.ordering.system.domain.valueobject.OrderStatus;
import com.ordering.system.outbox.OutboxStatus;
import com.ordering.system.saga.SagaStatus;
import lombok.*;

import jakarta.persistence.*;
import java.time.ZonedDateTime;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "payment_outbox")
@Entity
public class PaymentOutboxEntity {

    @Id
    private UUID id;

    private UUID sagaId;

    private ZonedDateTime createdAt;

    private ZonedDateTime processedAt;

    private String type;

    private String payload;

    @Enumerated(EnumType.STRING)
    private SagaStatus sagaStatus;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    @Enumerated(EnumType.STRING)
    private OutboxStatus outboxStatus;

    @Version
    private int version;

}

