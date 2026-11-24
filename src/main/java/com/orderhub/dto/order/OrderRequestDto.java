package com.orderhub.dto.order;

import com.orderhub.dto.orderitem.OrderItemRequestDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.util.List;

@Data
public class OrderRequestDto {

    @NotNull(message = "User ID is required")
    @Positive(message = "User ID must be positive")
    private Long userId;

    @NotEmpty(message = "Order items cannot be empty")
    @Valid
    private List<OrderItemRequestDto> orderItems;
}