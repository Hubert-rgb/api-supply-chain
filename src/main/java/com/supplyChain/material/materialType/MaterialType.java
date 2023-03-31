package com.supplyChain.material.materialType;

import com.supplyChain.company.supplierCompany.SupplierCompany;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class MaterialType {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    private float price;
    private String name;
    @ManyToOne
    @JoinColumn(name = "supplier_Company_id")
    private SupplierCompany supplierCompany;

    public MaterialType(String name, float price, SupplierCompany supplierCompany){
        this.name = name;
        this.price = price;
        this.supplierCompany = supplierCompany;
    }
}
