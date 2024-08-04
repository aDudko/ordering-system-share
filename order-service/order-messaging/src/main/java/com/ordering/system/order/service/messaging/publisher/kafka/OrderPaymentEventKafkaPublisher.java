package com.ordering.system.order.service.messaging.publisher.kafka;

import com.ordering.system.kafka.order.avro.model.PaymentRequestAvroModel;
import com.ordering.system.kafka.producer.KafkaMessageHelper;
import com.ordering.system.kafka.producer.KafkaProducer;
import com.ordering.system.order.service.domain.config.OrderServiceConfigData;
import com.ordering.system.order.service.domain.outbox.model.payment.OrderPaymentEventPayload;
import com.ordering.system.order.service.domain.outbox.model.payment.OrderPaymentOutboxMessage;
import com.ordering.system.order.service.domain.ports.output.message.publisher.payment.PaymentRequestMessagePublisher;
import com.ordering.system.order.service.messaging.mapper.OrderMessagingDataMapper;
import com.ordering.system.outbox.OutboxStatus;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.function.BiConsumer;

@Slf4j
@Component
@RequiredArgsConstructor
public class OrderPaymentEventKafkaPublisher implements PaymentRequestMessagePublisher {

    private final OrderMessagingDataMapper orderMessagingDataMapper;
    private final KafkaProducer<String, PaymentRequestAvroModel> kafkaProducer;
    private final OrderServiceConfigData orderServiceConfigData;
    private final KafkaMessageHelper kafkaMessageHelper;


    @Override
    public void publish(
            OrderPaymentOutboxMessage orderPaymentOutboxMessage,
            BiConsumer<OrderPaymentOutboxMessage, OutboxStatus> outboxCallback) {
        OrderPaymentEventPayload orderPaymentEventPayload = kafkaMessageHelper
                .getOrderEventPayload(orderPaymentOutboxMessage.getPayload(), OrderPaymentEventPayload.class);
        String sagaId = orderPaymentOutboxMessage.getSagaId().toString();
        log.info("Received OrderPaymentOutboxMessage for orderId: {} and sagaId: {}",
                orderPaymentEventPayload.getOrderId(),
                sagaId);
        try {
            PaymentRequestAvroModel paymentRequestAvroModel = orderMessagingDataMapper
                    .orderPaymentEventToPaymentRequestAvroModel(sagaId, orderPaymentEventPayload);
            kafkaProducer.send(
                    orderServiceConfigData.getPaymentRequestTopicName(),
                    sagaId,
                    paymentRequestAvroModel,
                    kafkaMessageHelper.getKafkaCallback(
                            orderServiceConfigData.getPaymentRequestTopicName(),
                            paymentRequestAvroModel,
                            orderPaymentOutboxMessage,
                            outboxCallback,
                            orderPaymentEventPayload.getOrderId(),
                            "PaymentRequestAvroModel"));
            log.info("OrderPaymentEventPayload sent to Kafka for orderId: {} and sagaId: {}",
                    orderPaymentEventPayload.getOrderId(), sagaId);
        } catch (Exception e) {
            log.error("Error while sending OrderPaymentEventPayload to kafka with orderId: {} and sagaId: {}," +
                            " error: {}", orderPaymentEventPayload.getOrderId(), sagaId, e.getMessage());
        }
    }

}