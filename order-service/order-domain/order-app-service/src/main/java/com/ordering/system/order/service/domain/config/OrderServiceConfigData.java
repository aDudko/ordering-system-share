package com.ordering.system.order.service.domain.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * This class will lot the configuration data from the order service prefix,
 * from a configuration file, like from the application YAML file.
 */

@Data
@Configuration
@ConfigurationProperties(prefix = "order-service")
public class OrderServiceConfigData {

    private String paymentRequestTopicName;

    private String paymentResponseTopicName;

    private String restaurantApprovalRequestTopicName;

    private String restaurantApprovalResponseTopicName;

}
