package com.supplyChain.orders.customerOrder;

import com.supplyChain.orders.order.Order;
import com.supplyChain.product.productType.ProductType;
import com.supplyChain.users.customer.Customer;
import com.supplyChain.users.distributor.Distributor;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table
@Entity
public class CustomerOrder extends Order {
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    @ManyToOne
    @JoinColumn(name = "distributor_id")
    private Distributor distributor;

    @ElementCollection
    @CollectionTable(name = "order_product_mapping",
            joinColumns = {@JoinColumn(name = "order_id", referencedColumnName = "id")})
    @MapKeyColumn(name = "product_name")
    @Column(name = "quantity")
    private HashMap<ProductType, Integer> productQuantityMap;
}
