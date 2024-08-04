package com.ordering.system.customer.service.domain;

import com.ordering.system.customer.service.domain.entity.Customer;
import com.ordering.system.customer.service.domain.event.CustomerCreatedEvent;

public interface CustomerDomainService {

    CustomerCreatedEvent validateAndInitiateCustomer(Customer customer);

}
