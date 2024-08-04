package com.ordering.system.restaurant.service.domain.config;

import com.ordering.system.restaurant.service.domain.RestaurantDomainService;
import com.ordering.system.restaurant.service.domain.impl.RestaurantDomainServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public RestaurantDomainService restaurantDomainService() {
        return new RestaurantDomainServiceImpl();
    }

}
