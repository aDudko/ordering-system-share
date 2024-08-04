package com.ordering.system.payment.service.domain.ports.output.message.publisher;

import com.ordering.system.outbox.OutboxStatus;
import com.ordering.system.payment.service.domain.outbox.model.OrderOutboxMessage;

import java.util.function.BiConsumer;

public interface PaymentResponseMessagePublisher {

    void publish(OrderOutboxMessage orderOutboxMessage,
                 BiConsumer<OrderOutboxMessage, OutboxStatus> outboxCallback);

}
