package com.ordering.system.restaurant.service.domain.event;

import com.ordering.system.domain.event.DomainEvent;
import com.ordering.system.domain.valueobject.RestaurantId;
import com.ordering.system.restaurant.service.domain.entity.OrderApproval;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.ZonedDateTime;
import java.util.List;

@Getter
@RequiredArgsConstructor
public abstract class OrderApprovalEvent implements DomainEvent<OrderApproval> {

    private final OrderApproval orderApproval;

    private final RestaurantId restaurantId;

    private final List<String> failureMessages;

    private final ZonedDateTime createdAt;

}
