package com.supplyChain.company.distributionCompany;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.supplyChain.company.company.Company;
import com.supplyChain.product.productType.ProductType;
import com.supplyChain.users.distributor.Distributor;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DistributionCompany extends Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ElementCollection
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @CollectionTable(name = "products_in_stock_of_distribution_company",
            joinColumns = {@JoinColumn(name = "distribution_company_id", referencedColumnName = "id")})
    @Column(name = "quantity")
    private Map<Integer, Integer> productsInStock = new HashMap<>();

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @OneToMany(mappedBy = "distributionCompany", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Distributor> workers = new ArrayList<>();

}
