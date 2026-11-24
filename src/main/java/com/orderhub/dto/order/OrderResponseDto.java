package com.orderhub.dto.order;

import com.orderhub.dto.orderitem.OrderItemResponseDto;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
public class OrderResponseDto {

    private Long orderId;
    private Long userId;
    private LocalDate orderDate;
    private Double totalAmount;
    private String status;
    private List<OrderItemResponseDto> orderItems;
}