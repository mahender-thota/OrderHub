package com.orderhub.dto.orderitem;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderItemResponseDto {

    private Long orderItemId;
    private Long productId;
    private String productname;
    private Integer quantity;
    private Double price;
    private Double discount;
    private Double totalPrice;
}