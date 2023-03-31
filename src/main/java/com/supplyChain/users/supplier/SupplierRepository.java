package com.supplyChain.users.supplier;

import com.supplyChain.users.user.UserRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepository extends UserRepository<Supplier> {
}