package com.supplyChain.users.supplier;

import com.supplyChain.company.supplierCompany.SupplierCompany;
import com.supplyChain.users.user.User;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
public class Supplier extends User {
    @ManyToOne
    @JoinColumn(name = "supplier_company_id")
    private SupplierCompany supplierCompany;
}
