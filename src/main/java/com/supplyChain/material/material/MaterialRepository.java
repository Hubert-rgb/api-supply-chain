package com.supplyChain.material.material;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MaterialRepository extends JpaRepository<Material, Long> {
    @Query("select m from Material m where m.materialType.id = ?1")
    List<Material> findByMaterialType_Id(Long id);

    @Query("select m from Material m where m.company.id = ?1")
    List<Material> findByCompany_Id(Long id);

    @Query("select m from Material m where m.userEntity.id = ?1")
    List<Material> findByUser_Id(Long id);
}
