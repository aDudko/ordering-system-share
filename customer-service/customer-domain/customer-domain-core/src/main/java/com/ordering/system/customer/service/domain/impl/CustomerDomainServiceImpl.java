package com.ordering.system.customer.service.domain.impl;

import com.ordering.system.customer.service.domain.CustomerDomainService;
import com.ordering.system.customer.service.domain.entity.Customer;
import com.ordering.system.customer.service.domain.event.CustomerCreatedEvent;
import lombok.extern.slf4j.Slf4j;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import static com.ordering.system.domain.DomainConstants.UTC;

@Slf4j
public class CustomerDomainServiceImpl implements CustomerDomainService {

    public CustomerCreatedEvent validateAndInitiateCustomer(Customer customer) {
        // Any business logic required to run for a customer creation
        log.info("Customer with id: {} is initiated", customer.getId().getValue());
        return new CustomerCreatedEvent(customer, ZonedDateTime.now(ZoneId.of(UTC)));
    }

}

