package com.supplyChain.product.productType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductTypeRepository extends JpaRepository<ProductType, Long> {
    @Query("select p from ProductType p where p.manufactureCompany.id = ?1")
    List<ProductType> findByManufactureCompany_Id(Long id);
}