package com.supplyChain.product.productType;

import com.supplyChain.company.manufactureCompany.ManufactureCompany;
import com.supplyChain.material.materialType.MaterialType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class ProductType {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    private float price;
    private String name;

    @ManyToOne
    @JoinColumn(name = "manufacture_company_id")
    private ManufactureCompany manufactureCompany;

    @ElementCollection
    @CollectionTable(name = "product_required_material_mapping",
            joinColumns = {@JoinColumn(name = "order_id", referencedColumnName = "id")})
    @MapKeyColumn(name = "material_id")
    @Column(name = "quantity")
    private HashMap<MaterialType, Integer> materialQuantityRequiredToMakeHashMap;
}
