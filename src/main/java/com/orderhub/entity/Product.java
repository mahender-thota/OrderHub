
package com.orderhub.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "products")
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    private String productName;

    private Double price;

    private Integer quantity;

    @OneToMany(mappedBy = "product")
    private List<OrderItem> orderItems;
}
