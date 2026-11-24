package com.orderhub.controller;

import com.orderhub.dto.order.OrderRequestDto;
import com.orderhub.dto.order.OrderResponseDto;
import com.orderhub.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}