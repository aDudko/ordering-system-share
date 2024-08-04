package com.ordering.system.order.service.domain.config;

import com.ordering.system.order.service.domain.OrderDomainService;
import com.ordering.system.order.service.domain.impl.OrderDomainServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public OrderDomainService orderDomainService() {
        return new OrderDomainServiceImpl();
    }

}
