package com.orderhub.builder;

import com.orderhub.dto.orderitem.OrderItemRequestDto;
import com.orderhub.dto.orderitem.OrderItemResponseDto;
import com.orderhub.model.OrderItem;
import com.orderhub.model.Product;

public class OrderItemBuilder {

    // Request DTO to Entity
    public static OrderItem buildOrderItem(OrderItemRequestDto requestDto, Product product, Double price) {

        return OrderItem.builder()
                .product(product)
                .quantity(requestDto.getQuantity())
                .price(price)
                .discount(requestDto.getDiscount())
                .build();
    }

    // Entity to Response DTO
    public static OrderItemResponseDto buildOrderItemResponse(OrderItem orderItem) {

        Double totalPrice = (orderItem.getPrice() * orderItem.getQuantity()) - orderItem.getDiscount();

        return OrderItemResponseDto.builder()
                .orderItemId(orderItem.getOrderItemId())
                .productId(orderItem.getProduct().getProductId())
                .productname(orderItem.getProduct().getProductname())
                .quantity(orderItem.getQuantity())
                .price(orderItem.getPrice())
                .discount(orderItem.getDiscount())
                .totalPrice(totalPrice)
                .build();
    }
}