package com.supplyChain.orders.manufactureOrder;

import com.supplyChain.orders.order.OrderRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManufactureOrderRepository extends OrderRepository<ManufactureOrder> {
}