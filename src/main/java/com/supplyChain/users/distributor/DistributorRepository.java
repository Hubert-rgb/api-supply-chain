package com.supplyChain.users.distributor;

import com.supplyChain.users.user.UserRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DistributorRepository extends UserRepository<Distributor> {
}