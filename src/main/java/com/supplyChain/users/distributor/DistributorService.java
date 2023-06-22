package com.supplyChain.users.distributor;

import com.supplyChain.users.manufacturer.Manufacturer;
import com.supplyChain.users.manufacturer.ManufacturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistributorService {
    @Autowired
    private DistributorRepository repository;

    public Distributor getDistributorById(long id){
        return repository.findById(id).orElse(null);
    }
    public List<Distributor> getAllDistributors(){
        return repository.findAll();
    }
    public Distributor saveDistributor(Distributor manufacturer){
        return repository.save(manufacturer);
    }

    public List<Distributor> getDistributorsByCompany(long companyId){
        return repository.findByDistributionCompany_Id(companyId);
    }
}
