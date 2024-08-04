package com.ordering.system.order.service.messaging.mapper;

import com.ordering.system.kafka.order.avro.model.*;
import com.ordering.system.order.service.domain.dto.message.CustomerModel;
import com.ordering.system.order.service.domain.dto.message.PaymentResponse;
import com.ordering.system.order.service.domain.dto.message.RestaurantApprovalResponse;
import com.ordering.system.order.service.domain.outbox.model.approval.OrderApprovalEventPayload;
import com.ordering.system.order.service.domain.outbox.model.payment.OrderPaymentEventPayload;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Objects to send they to Kafka
 */

@Component
public class OrderMessagingDataMapper {

    public PaymentResponse paymentResponseAvroModelToPaymentResponse(
            PaymentResponseAvroModel paymentResponseAvroModel) {
        return PaymentResponse.builder()
                .id(paymentResponseAvroModel.getId())
                .sagaId(paymentResponseAvroModel.getSagaId())
                .orderId(paymentResponseAvroModel.getOrderId())
                .paymentId(paymentResponseAvroModel.getPaymentId())
                .customerId(paymentResponseAvroModel.getCustomerId())
                .price(paymentResponseAvroModel.getPrice())
                .createdAt(paymentResponseAvroModel.getCreatedAt())
                .paymentStatus(com.ordering.system.domain.valueobject.PaymentStatus
                        .valueOf(paymentResponseAvroModel.getPaymentStatus().name()))
                .failureMessages(paymentResponseAvroModel.getFailureMessages())
                .build();
    }

    public RestaurantApprovalResponse approvalResponseAvroModelToApprovalResponse(
            RestaurantApprovalResponseAvroModel approvalResponseAvroModel) {
        return RestaurantApprovalResponse.builder()
                .id(approvalResponseAvroModel.getId())
                .sagaId(approvalResponseAvroModel.getSagaId())
                .orderId(approvalResponseAvroModel.getOrderId())
                .restaurantId(approvalResponseAvroModel.getRestaurantId())
                .orderApprovalStatus(com.ordering.system.domain.valueobject.OrderApprovalStatus
                        .valueOf(approvalResponseAvroModel.getOrderApprovalStatus().name()))
                .failureMessages(approvalResponseAvroModel.getFailureMessages())
                .build();
    }

    public PaymentRequestAvroModel orderPaymentEventToPaymentRequestAvroModel(
            String sagaId,
            OrderPaymentEventPayload
            orderPaymentEventPayload) {
        return PaymentRequestAvroModel.newBuilder()
                .setId(UUID.randomUUID().toString())
                .setSagaId(sagaId)
                .setCustomerId(orderPaymentEventPayload.getCustomerId())
                .setOrderId(orderPaymentEventPayload.getOrderId())
                .setPrice(orderPaymentEventPayload.getPrice())
                .setCreatedAt(orderPaymentEventPayload.getCreatedAt().toInstant())
                .setPaymentOrderStatus(PaymentOrderStatus.valueOf(orderPaymentEventPayload.getPaymentOrderStatus()))
                .build();
    }

    public RestaurantApprovalRequestAvroModel orderApprovalEventToRestaurantApprovalRequestAvroModel(
            String sagaId,
            OrderApprovalEventPayload orderApprovalEventPayload) {
        return RestaurantApprovalRequestAvroModel.newBuilder()
                .setId(UUID.randomUUID().toString())
                .setSagaId(sagaId)
                .setOrderId(orderApprovalEventPayload.getOrderId())
                .setRestaurantId(orderApprovalEventPayload.getRestaurantId())
                .setRestaurantOrderStatus(RestaurantOrderStatus.valueOf(
                        orderApprovalEventPayload.getRestaurantOrderStatus()))
                .setProducts(orderApprovalEventPayload.getProducts().stream()
                        .map(orderApprovalEventProduct ->
                                com.ordering.system.kafka.order.avro.model.Product.newBuilder()
                                        .setId(orderApprovalEventProduct.getId())
                                        .setQuantity(orderApprovalEventProduct.getQuantity())
                                        .build())
                        .collect(Collectors.toList()))
                .setPrice(orderApprovalEventPayload.getPrice())
                .setCreatedAt(orderApprovalEventPayload.getCreatedAt().toInstant())
                .build();
    }

    public CustomerModel customerAvroModeltoCustomerModel(CustomerAvroModel customerAvroModel) {
        return CustomerModel.builder()
                .id(customerAvroModel.getId())
                .username(customerAvroModel.getUsername())
                .firstName(customerAvroModel.getFirstName())
                .lastName(customerAvroModel.getLastName())
                .build();
    }

}
