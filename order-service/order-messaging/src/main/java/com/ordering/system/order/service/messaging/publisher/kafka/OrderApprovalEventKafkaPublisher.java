package com.ordering.system.order.service.messaging.publisher.kafka;

import com.ordering.system.kafka.order.avro.model.RestaurantApprovalRequestAvroModel;
import com.ordering.system.kafka.producer.KafkaMessageHelper;
import com.ordering.system.kafka.producer.KafkaProducer;
import com.ordering.system.order.service.domain.config.OrderServiceConfigData;
import com.ordering.system.order.service.domain.outbox.model.approval.OrderApprovalEventPayload;
import com.ordering.system.order.service.domain.outbox.model.approval.OrderApprovalOutboxMessage;
import com.ordering.system.order.service.domain.ports.output.message.publisher.restaurantapproval.RestaurantApprovalRequestMessagePublisher;
import com.ordering.system.order.service.messaging.mapper.OrderMessagingDataMapper;
import com.ordering.system.outbox.OutboxStatus;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.function.BiConsumer;

@Slf4j
@Component
@RequiredArgsConstructor
public class OrderApprovalEventKafkaPublisher implements RestaurantApprovalRequestMessagePublisher {

    private final OrderMessagingDataMapper orderMessagingDataMapper;
    private final KafkaProducer<String, RestaurantApprovalRequestAvroModel> kafkaProducer;
    private final OrderServiceConfigData orderServiceConfigData;
    private final KafkaMessageHelper kafkaMessageHelper;


    @Override
    public void publish(
            OrderApprovalOutboxMessage orderApprovalOutboxMessage,
            BiConsumer<OrderApprovalOutboxMessage, OutboxStatus> outboxCallback) {
        OrderApprovalEventPayload orderApprovalEventPayload = kafkaMessageHelper
                .getOrderEventPayload(orderApprovalOutboxMessage.getPayload(), OrderApprovalEventPayload.class);
        String sagaId = orderApprovalOutboxMessage.getSagaId().toString();
        log.info("Received OrderApprovalOutboxMessage for orderId: {} and sagaId: {}",
                orderApprovalEventPayload.getOrderId(),
                sagaId);
        try {
            RestaurantApprovalRequestAvroModel restaurantApprovalRequestAvroModel = orderMessagingDataMapper
                    .orderApprovalEventToRestaurantApprovalRequestAvroModel(sagaId, orderApprovalEventPayload);
            kafkaProducer.send(
                    orderServiceConfigData.getRestaurantApprovalRequestTopicName(),
                    sagaId,
                    restaurantApprovalRequestAvroModel,
                    kafkaMessageHelper.getKafkaCallback(
                            orderServiceConfigData.getRestaurantApprovalRequestTopicName(),
                            restaurantApprovalRequestAvroModel,
                            orderApprovalOutboxMessage,
                            outboxCallback,
                            orderApprovalEventPayload.getOrderId(),
                            "RestaurantApprovalRequestAvroModel"));
            log.info("OrderApprovalEventPayload sent to kafka for orderId: {} and sagaId: {}",
                    restaurantApprovalRequestAvroModel.getOrderId(), sagaId);
        } catch (Exception e) {
            log.error("Error while sending OrderApprovalEventPayload to kafka for orderId: {} and sagaId: {}," +
                    " error: {}", orderApprovalEventPayload.getOrderId(), sagaId, e.getMessage());
        }
    }

}
