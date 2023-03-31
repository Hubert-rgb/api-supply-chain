package com.supplyChain.orders.customerOrder;

import com.supplyChain.orders.order.OrderRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerOrderRepository extends OrderRepository<CustomerOrder> {
}