package com.orderhub.builder;

import com.orderhub.dto.order.OrderResponseDto;
import com.orderhub.dto.orderitem.OrderItemResponseDto;
import com.orderhub.model.Order;
import com.orderhub.model.OrderItem;
import com.orderhub.model.Users;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OrderBuilder {

    // Entity creation
    public static Order buildOrder(Users users, List<OrderItem> orderItems, Double totalAmount) {

        return Order.builder()
                .users(users)
                .orderItems(orderItems)
                .totalAmount(totalAmount)
                .orderDate(LocalDate.now())
                .status("PLACED")
                .build();
    }

    // Entity to Response DTO
    public static OrderResponseDto buildOrderResponse(Order order) {

        List<OrderItemResponseDto> itemResponses = new ArrayList<>();

        for (OrderItem item : order.getOrderItems()) {
            OrderItemResponseDto orderItemResponseDto = OrderItemBuilder.buildOrderItemResponse(item);
            itemResponses.add(orderItemResponseDto);
        }

        return OrderResponseDto.builder()
                .orderId(order.getOrderId())
                .userId(order.getUsers().getUserId())
                .orderDate(order.getOrderDate())
                .totalAmount(order.getTotalAmount())
                .status(order.getStatus())
                .orderItems(itemResponses)
                .build();
    }
}