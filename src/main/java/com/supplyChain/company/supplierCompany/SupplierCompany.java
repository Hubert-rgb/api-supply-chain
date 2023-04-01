package com.supplyChain.company.supplierCompany;

import com.supplyChain.company.company.Company;
import com.supplyChain.material.materialType.MaterialType;
import com.supplyChain.users.supplier.Supplier;
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
public class SupplierCompany extends Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    /*@OneToMany(mappedBy = "supplierCompany", cascade = jakarta.persistence.CascadeType.PERSIST, orphanRemoval = true)
    private List<MaterialType> supplierProducts*/;

    @ElementCollection
    @CollectionTable(name = "materials_in_stock_of_supplier_company",
            joinColumns = {@JoinColumn(name = "supplier_company_id", referencedColumnName = "id")})
    @Column(name = "quantity")
    private Map<Integer, Integer> materialsInStock;

    @OneToMany(mappedBy = "supplierCompany", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Supplier> workers;
}
