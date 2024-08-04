package com.ordering.system.restaurant.service.dataaccess.restaurant.entity;

import com.ordering.system.domain.valueobject.OrderApprovalStatus;
import lombok.*;

import jakarta.persistence.*;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "order_approval", schema = "restaurant")
@Entity
public class OrderApprovalEntity {

    @Id
    private UUID id;

    private UUID restaurantId;

    private UUID orderId;

    @Enumerated(EnumType.STRING)
    private OrderApprovalStatus status;

}
