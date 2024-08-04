package com.ordering.system.order.service.domain.dto.message;

import com.ordering.system.domain.valueobject.OrderApprovalStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.Instant;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class RestaurantApprovalResponse {

    private String id;

    // Use a sagaId in the messages between the services
    private String sagaId;

    private String orderId;

    private String restaurantId;

    private Instant createdAt;

    private OrderApprovalStatus orderApprovalStatus;

    private List<String> failureMessages;

}
