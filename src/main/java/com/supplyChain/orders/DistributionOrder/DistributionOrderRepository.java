package com.supplyChain.orders.DistributionOrder;

import com.supplyChain.orders.order.OrderRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DistributionOrderRepository extends OrderRepository<DistributionOrder> {
}