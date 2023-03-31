package com.supplyChain.orders.order;

import com.supplyChain.location.Address;
import com.supplyChain.enumClasses.status.OrderStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@MappedSuperclass
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    private LocalDateTime orderTime;
    @Enumerated
    private OrderStatus orderStatus;
    @ManyToOne
    @JoinColumn(name = "order_address_id")
    private Address orderAddress;

    private float price;
}
