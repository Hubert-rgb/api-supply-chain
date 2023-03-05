package com.supplyChain.entityClass.orders;

import com.supplyChain.entityClass.Material;
import com.supplyChain.entityClass.users.Manufacturer;
import com.supplyChain.entityClass.users.Supplier;
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
public class ManufactureOrder extends Order{
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
    private HashMap<Material, Integer> materialQuantityMap;
}
