package com.supplyChain.material.materialType;

import com.fasterxml.jackson.annotation.*;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private float price;
    private String name;

    @ManyToOne
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @JsonIdentityReference(alwaysAsId = true)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @JoinColumn(name = "supplier_Company_id")
    private SupplierCompany supplierCompany;

    public void assignSupplierCompany(SupplierCompany supplierCompany){
        this.supplierCompany = supplierCompany;
    }

    public MaterialType(String name, float price){
        this.name = name;
        this.price = price;
    }
}
