package com.supplyChain.users.supplier;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.supplyChain.company.supplierCompany.SupplierCompany;
import com.supplyChain.enumClasses.type.UserType;
import com.supplyChain.users.user.UserEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
public class Supplier extends UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @JoinColumn(name = "supplier_company_id")
    private SupplierCompany supplierCompany;

    public Supplier(String name/*, SupplierCompany supplierCompany*/){
        super(name, UserType.SUPPLIER);
        //this.supplierCompany = supplierCompany;
    }
}
