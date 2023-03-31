package com.supplyChain.company.company;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface CompanyRepository<T extends Company> extends JpaRepository<T, Long> {
}