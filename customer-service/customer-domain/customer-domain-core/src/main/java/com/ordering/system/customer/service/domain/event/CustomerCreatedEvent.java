package com.ordering.system.customer.service.domain.event;

import com.ordering.system.customer.service.domain.entity.Customer;
import com.ordering.system.domain.event.DomainEvent;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.ZonedDateTime;

@RequiredArgsConstructor
public class CustomerCreatedEvent implements DomainEvent<Customer> {

    @Getter
    private final Customer customer;

    private final ZonedDateTime createdAt;

}
