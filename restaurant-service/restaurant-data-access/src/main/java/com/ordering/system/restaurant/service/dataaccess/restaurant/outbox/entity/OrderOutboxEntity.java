package com.ordering.system.restaurant.service.dataaccess.restaurant.outbox.entity;

import com.ordering.system.domain.valueobject.OrderApprovalStatus;
import com.ordering.system.outbox.OutboxStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.ZonedDateTime;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "order_outbox")
@Entity
public class OrderOutboxEntity {

    @Id
    private UUID id;

    private UUID sagaId;

    private ZonedDateTime createdAt;

    private ZonedDateTime processedAt;

    private String type;

    private String payload;

    @Enumerated(EnumType.STRING)
    private OutboxStatus outboxStatus;

    @Enumerated(EnumType.STRING)
    private OrderApprovalStatus approvalStatus;

    private int version;

}

