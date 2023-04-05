package com.supplyChain.users.supplier;

import com.supplyChain.users.user.UserRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SupplierRepository extends UserRepository<Supplier> {
    @Query("select s from Supplier s where s.supplierCompany.id = ?1")
    List<Supplier> findBySupplierCompany_Id(Long id);
}