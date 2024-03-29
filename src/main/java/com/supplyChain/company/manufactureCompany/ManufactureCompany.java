package com.supplyChain.company.manufactureCompany;

import com.supplyChain.company.company.Company;
import com.supplyChain.material.materialType.MaterialType;
import com.supplyChain.product.productType.ProductType;
import com.supplyChain.orders.manufactureOrder.ManufactureOrder;
import com.supplyChain.users.manufacturer.Manufacturer;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ManufactureCompany extends Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToMany(mappedBy = "manufactureCompany", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private List<ProductType> manufactureProductTypes;

    @ElementCollection
    @CollectionTable(name = "products_in_stock_of_manufacture_company",
            joinColumns = @JoinColumn(name = "manufacture_company_id", referencedColumnName = "id"))
    @Column(name = "quantity")
    private Map<Integer, Integer> productsInStock;

    @ElementCollection
    @CollectionTable(name = "materials_in_stock_of_manufacture_company",
            joinColumns = {@JoinColumn(name = "manufacture_company_id", referencedColumnName = "id")})
    @Column(name = "quantity")
    private Map<Integer, Integer> materialsInStock;

    @OneToMany(mappedBy = "manufactureCompany", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Manufacturer> workers;

    @OneToMany(mappedBy = "manufactureCompany")
    private List<ManufactureOrder> ordersToManufacture;
}
