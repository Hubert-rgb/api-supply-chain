package com.supplyChain.users.manufacturer;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.supplyChain.company.manufactureCompany.ManufactureCompany;
import com.supplyChain.users.user.UserEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
public class Manufacturer extends UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @JoinColumn(name = "manufacture_company_id")
    private ManufactureCompany manufactureCompany;
}
