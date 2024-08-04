package com.ordering.system.payment.service.domain.config;

import com.ordering.system.payment.service.domain.PaymentDomainService;
import com.ordering.system.payment.service.domain.impl.PaymentDomainServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public PaymentDomainService paymentDomainService() {
        return new PaymentDomainServiceImpl();
    }

}
