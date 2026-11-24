package com.orderhub.service;

import com.orderhub.builder.OrderBuilder;
import com.orderhub.builder.OrderItemBuilder;
import com.orderhub.dto.order.OrderRequestDto;
import com.orderhub.dto.order.OrderResponseDto;
import com.orderhub.dto.orderitem.OrderItemRequestDto;
import com.orderhub.execption.ProductNotFoundException;
import com.orderhub.execption.UserNotFoundException;
import com.orderhub.model.Order;
import com.orderhub.model.OrderItem;
import com.orderhub.model.Product;
import com.orderhub.model.Users;
import com.orderhub.repository.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private ProductRepository productRepository;

    @Transactional
    public OrderResponseDto createOrder(OrderRequestDto requestDto){
        Long userId = requestDto.getUserId();
        Users user = usersRepository.findById(userId)
                                     .orElseThrow(() -> new UserNotFoundException("user not found"));

        List<OrderItem> orderItemList=new ArrayList<>();
        Double totalAmount=0.0;

        for (OrderItemRequestDto item : requestDto.getOrderItems()){
            Product product = productRepository.findById(item.getProductId())
                    .orElseThrow(() -> new ProductNotFoundException("Product not fount" + item.getProductId()));

            if (item.getDiscount() < 0 || item.getDiscount() > 100) {
                throw new RuntimeException("Discount must be between 0 and 100");
            }

            Double subTotal = product.getPrice()* item.getQuantity();
            Double discountAmount = (item.getDiscount()*subTotal)/100;
            Double finalAmount = subTotal - discountAmount;
            totalAmount += finalAmount;

            OrderItem orderItem = OrderItemBuilder.buildOrderItem(item, product, product.getPrice());
            orderItemList.add(orderItem);

            product.setQuantity(product.getQuantity()-item.getQuantity());
            productRepository.save(product);
        }
        Order order = OrderBuilder.buildOrder(user, orderItemList, totalAmount);

        for (OrderItem item : orderItemList){
            item.setOrder(order);
        }
        Order saved = orderRepository.save(order);

        return OrderBuilder.buildOrderResponse(saved);
    }

}