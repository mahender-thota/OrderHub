
package com.orderhub.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    private LocalDate orderDate;

    private Double totalAmount;

    private String status;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users users;

    @OneToMany(mappedBy = "order",  cascade = CascadeType.ALL)
    private List<OrderItem> orderItems;
}
