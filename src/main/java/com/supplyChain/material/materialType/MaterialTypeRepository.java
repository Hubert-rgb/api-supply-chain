package com.supplyChain.material.materialType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MaterialTypeRepository extends JpaRepository<MaterialType, Long> {
    @Query("select m from MaterialType m where m.supplierCompany.id = ?1")
    List<MaterialType> findBySupplierCompany_Id(Long id);
}