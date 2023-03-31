package com.supplyChain.orders.DistributionOrder;

import com.supplyChain.company.distributionCompany.DistributionCompany;
import com.supplyChain.orders.order.Order;
import com.supplyChain.product.productType.ProductType;
import com.supplyChain.users.distributor.Distributor;
import com.supplyChain.users.manufacturer.Manufacturer;
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
public class DistributionOrder extends Order {
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Distributor distributor;


    @ManyToOne
    @JoinColumn(name = "distribution_company_id")
    private DistributionCompany distributionCompany;
    @ManyToOne
    @JoinColumn(name = "distributor_id")
    private Manufacturer manufacturer;

    @ElementCollection
    @CollectionTable(name = "order_product_mapping",
            joinColumns = {@JoinColumn(name = "order_id", referencedColumnName = "id")})
    @MapKeyColumn(name = "product_name")
    @Column(name = "quantity")
    private HashMap<ProductType, Integer> productQuantityMap;
}
