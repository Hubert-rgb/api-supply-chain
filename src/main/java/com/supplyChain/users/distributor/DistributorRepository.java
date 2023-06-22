package com.supplyChain.users.distributor;

import com.supplyChain.users.user.UserRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DistributorRepository extends UserRepository<Distributor> {
    @Query("select d from Distributor d where d.distributionCompany.id = ?1")
    List<Distributor> findByDistributionCompany_Id(Long id);
}