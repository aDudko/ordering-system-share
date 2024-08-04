package com.ordering.system.payment.service.dataaccess.payment.entity;

import com.ordering.system.domain.valueobject.PaymentStatus;
import lombok.*;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "payments")
@Entity
public class PaymentEntity {

    @Id
    private UUID id;

    private UUID customerId;

    private UUID orderId;

    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    private PaymentStatus status;

    private ZonedDateTime createdAt;

}
