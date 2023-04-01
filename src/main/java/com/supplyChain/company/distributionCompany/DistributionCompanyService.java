package com.supplyChain.company.distributionCompany;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistributionCompanyService {
    @Autowired
    private DistributionCompanyRepository repository;

    public DistributionCompany getDistributionCompanyById(long id){
        return repository.findById(id).orElse(null);
    }
    public List<DistributionCompany> getAllDistributionCompany(){
        return repository.findAll();
    }
    public DistributionCompany saveDistributionCompany(DistributionCompany distributionCompany){
        return repository.save(distributionCompany);
    }
}
