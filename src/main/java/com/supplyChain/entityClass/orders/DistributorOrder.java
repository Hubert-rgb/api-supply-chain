package com.supplyChain.entityClass.orders;

import com.supplyChain.entityClass.Product;
import com.supplyChain.entityClass.users.Distributor;
import com.supplyChain.entityClass.users.Manufacturer;
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
public class DistributorOrder extends Order{
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Distributor distributor;
    @ManyToOne
    @JoinColumn(name = "distributor_id")
    private Manufacturer manufacturer;

    @ElementCollection
    @CollectionTable(name = "order_product_mapping",
            joinColumns = {@JoinColumn(name = "order_id", referencedColumnName = "id")})
    @MapKeyColumn(name = "product_name")
    @Column(name = "quantity")
    private HashMap<Product, Integer> productQuantityMap;
}
