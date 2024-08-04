package com.ordering.system.order.service.domain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = {"com.ordering.system.order.service.dataaccess", "com.ordering.system.dataaccess" })
@EntityScan(basePackages = {"com.ordering.system.order.service.dataaccess", "com.ordering.system.dataaccess"})
@SpringBootApplication(scanBasePackages = "com.ordering.system")
public class OrderServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderServiceApplication.class, args);
    }

}
