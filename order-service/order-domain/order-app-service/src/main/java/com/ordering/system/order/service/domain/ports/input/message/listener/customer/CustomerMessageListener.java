package com.ordering.system.order.service.domain.ports.input.message.listener.customer;

import com.ordering.system.order.service.domain.dto.message.CustomerModel;

public interface CustomerMessageListener {

    void customerCreated(CustomerModel customerModel);

}
