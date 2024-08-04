package com.ordering.system.order.service.domain.ports;

import com.ordering.system.order.service.domain.dto.create.CreateOrderCommand;
import com.ordering.system.order.service.domain.dto.create.CreateOrderResponse;
import com.ordering.system.order.service.domain.event.OrderCreatedEvent;
import com.ordering.system.order.service.domain.mapper.OrderDataMapper;
import com.ordering.system.order.service.domain.outbox.scheduler.payment.PaymentOutboxHelper;
import com.ordering.system.outbox.OutboxStatus;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Slf4j
@Component
@RequiredArgsConstructor
public class OrderCreateCommandHandler {

    private final OrderCreateHelper orderCreateHelper;
    private final OrderDataMapper orderDataMapper;
    private final PaymentOutboxHelper paymentOutboxHelper;
    private final OrderSagaHelper orderSagaHelper;


    @Transactional
    public CreateOrderResponse createOrder(CreateOrderCommand createOrderCommand) {
        OrderCreatedEvent orderCreatedEvent = orderCreateHelper.persistOrder(createOrderCommand);
        log.info("Order is created with id: {}", orderCreatedEvent.getOrder().getId().getValue());
        CreateOrderResponse createOrderResponse = orderDataMapper
                .orderToCreateOrderResponse(orderCreatedEvent.getOrder(), "Order created successfully");
        paymentOutboxHelper.savePaymentOutboxMessage(
                orderDataMapper.orderCreatedEventToOrderPaymentEventPayload(orderCreatedEvent),
                orderCreatedEvent.getOrder().getOrderStatus(),
                orderSagaHelper.orderStatusToSagaStatus(orderCreatedEvent.getOrder().getOrderStatus()),
                OutboxStatus.STARTED,
                UUID.randomUUID());
        log.info("Returning CreateOrderResponse with orderId: {}", orderCreatedEvent.getOrder().getId());
        return createOrderResponse;
    }

}
