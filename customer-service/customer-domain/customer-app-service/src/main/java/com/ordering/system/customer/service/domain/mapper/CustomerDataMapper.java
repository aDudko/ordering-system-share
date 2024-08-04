package com.ordering.system.customer.service.domain.mapper;

import com.ordering.system.customer.service.domain.create.CreateCustomerCommand;
import com.ordering.system.customer.service.domain.create.CreateCustomerResponse;
import com.ordering.system.customer.service.domain.entity.Customer;
import com.ordering.system.domain.valueobject.CustomerId;
import org.springframework.stereotype.Component;

@Component
public class CustomerDataMapper {

    public Customer createCustomerCommandToCustomer(CreateCustomerCommand createCustomerCommand) {
        return new Customer(new CustomerId(createCustomerCommand.getCustomerId()),
                createCustomerCommand.getUsername(),
                createCustomerCommand.getFirstName(),
                createCustomerCommand.getLastName());
    }

    public CreateCustomerResponse customerToCreateCustomerResponse(Customer customer, String message) {
        return new CreateCustomerResponse(customer.getId().getValue(), message);
    }

}