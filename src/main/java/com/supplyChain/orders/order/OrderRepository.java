package com.supplyChain.orders.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface OrderRepository<T extends Order> extends JpaRepository<T, Long> {
}