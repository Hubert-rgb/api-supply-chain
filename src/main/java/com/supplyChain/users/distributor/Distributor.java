package com.supplyChain.users.distributor;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.supplyChain.company.distributionCompany.DistributionCompany;
import com.supplyChain.users.user.UserEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter

public class Distributor extends UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @JoinColumn(name = "distribution_company_id")
    private DistributionCompany distributionCompany;
}
