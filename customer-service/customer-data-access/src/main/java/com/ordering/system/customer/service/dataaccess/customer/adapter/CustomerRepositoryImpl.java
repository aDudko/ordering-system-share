package com.ordering.system.customer.service.dataaccess.customer.adapter;

import com.ordering.system.customer.service.dataaccess.customer.mapper.CustomerDataAccessMapper;
import com.ordering.system.customer.service.dataaccess.customer.repository.CustomerJpaRepository;
import com.ordering.system.customer.service.domain.entity.Customer;
import com.ordering.system.customer.service.domain.ports.output.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomerRepositoryImpl implements CustomerRepository {

    private final CustomerJpaRepository customerJpaRepository;
    private final CustomerDataAccessMapper customerDataAccessMapper;


    @Override
    public Customer createCustomer(Customer customer) {
        return customerDataAccessMapper.customerEntityToCustomer(
                customerJpaRepository.save(customerDataAccessMapper.customerToCustomerEntity(customer)));
    }

}
