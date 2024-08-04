package com.ordering.system.customer.service.domain.ports.input.service;

import com.ordering.system.customer.service.domain.create.CreateCustomerCommand;
import com.ordering.system.customer.service.domain.create.CreateCustomerResponse;

import jakarta.validation.Valid;

public interface CustomerApplicationService {

    CreateCustomerResponse createCustomer(@Valid CreateCustomerCommand createCustomerCommand);

}
