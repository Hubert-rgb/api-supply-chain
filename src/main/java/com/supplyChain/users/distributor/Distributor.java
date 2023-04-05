package com.supplyChain.users.distributor;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.supplyChain.company.distributionCompany.DistributionCompany;
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

public class Distributor extends User {
    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @JoinColumn(name = "distribution_company_id")
    private DistributionCompany distributionCompany;
}
