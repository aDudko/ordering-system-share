package com.ordering.system.customer.service.config;

import com.ordering.system.customer.service.domain.CustomerDomainService;
import com.ordering.system.customer.service.domain.impl.CustomerDomainServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public CustomerDomainService customerDomainService() {
        return new CustomerDomainServiceImpl();
    }

}
