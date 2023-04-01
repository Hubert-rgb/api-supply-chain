package com.supplyChain.product.productType;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.supplyChain.company.manufactureCompany.ManufactureCompany;
import com.supplyChain.material.materialType.MaterialType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class ProductType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private float price;
    private String name;

    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @JoinColumn(name = "manufacture_company_id")
    private ManufactureCompany manufactureCompany;

    @ElementCollection
    @CollectionTable(name = "product_required_material_mapping",
            joinColumns = @JoinColumn(name = "product_Type_id"))
    //@MapKeyColumn(name = "material_id")
    @Column(name = "quantity")
    private Map<Integer, Integer> materialTypeIdQuantityToMake = new HashMap<Integer, Integer>();
}
