package com.supplyChain.users.manufacturer;

import com.supplyChain.users.user.UserRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ManufacturerRepository extends UserRepository<Manufacturer> {
    @Query("select m from Manufacturer m where m.manufactureCompany.id = ?1")
    List<Manufacturer> findByManufactureCompany_Id(Long id);
}