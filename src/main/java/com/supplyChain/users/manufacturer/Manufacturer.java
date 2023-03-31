package com.supplyChain.users.manufacturer;

import com.supplyChain.company.manufactureCompany.ManufactureCompany;
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
public class Manufacturer extends User {
    @ManyToOne
    @JoinColumn(name = "manufacture_company_id")
    private ManufactureCompany manufactureCompany;
}
