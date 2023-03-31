package com.supplyChain.orders.manufactureOrder;

import com.supplyChain.material.materialType.MaterialType;
import com.supplyChain.orders.order.Order;
import com.supplyChain.users.manufacturer.Manufacturer;
import com.supplyChain.users.supplier.Supplier;
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
public class ManufactureOrder extends Order {
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Manufacturer manufacturer;
    @ManyToOne
    @JoinColumn(name = "distributor_id")
    private Supplier supplier;

    @ElementCollection
    @CollectionTable(name = "order_material_mapping",
            joinColumns = {@JoinColumn(name = "order_id", referencedColumnName = "id")})
    @MapKeyColumn(name = "material_id")
    @Column(name = "quantity")
    private HashMap<MaterialType, Integer> materialQuantityMap;
}
