package com.supplyChain.users.manufacturer;

import com.supplyChain.users.user.UserRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManufacturerRepository extends UserRepository<Manufacturer> {
}