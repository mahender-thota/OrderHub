package com.orderhub.controller;

import com.orderhub.dto.order.OrderRequestDto;
import com.orderhub.dto.order.OrderResponseDto;
import com.orderhub.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/OrderHub/Orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/createOrder")
    public ResponseEntity<OrderResponseDto> createOrder(@RequestBody OrderRequestDto requestDto) {

        OrderResponseDto response = orderService.createOrder(requestDto);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    // Get Order By ID
    @GetMapping("/{orderId}")
    public ResponseEntity<OrderResponseDto> getOrderById(@PathVariable Long orderId) {

        return ResponseEntity.ok(orderService.getOrderById(orderId));
    }

    // Get All Orders
    @GetMapping("/all")
    public ResponseEntity<List<OrderResponseDto>> getAllOrders() {

        return ResponseEntity.ok(orderService.getAllOrders());
    }

    // Delete Order
    @DeleteMapping("/{orderId}")
    public ResponseEntity<String> deleteOrder(@PathVariable Long orderId) {

        orderService.deleteOrder(orderId);

        return ResponseEntity.ok("Order deleted successfully");
    }
}