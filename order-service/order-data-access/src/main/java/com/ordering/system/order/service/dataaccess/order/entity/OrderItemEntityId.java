package com.ordering.system.order.service.dataaccess.order.entity;

import lombok.*;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemEntityId implements Serializable {

    private Long id;

    private OrderEntity order;

}
