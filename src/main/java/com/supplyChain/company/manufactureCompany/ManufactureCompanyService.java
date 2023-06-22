package com.supplyChain.company.manufactureCompany;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManufactureCompanyService {
    @Autowired
    private ManufactureCompanyRepository repository;

    public ManufactureCompany getManufactureCompanyById(long id){
        return repository.findById(id).orElse(null);
    }
    public List<ManufactureCompany> getAllManufactureCompany(){
        return repository.findAll();
    }
    public ManufactureCompany saveManufactureCompany(ManufactureCompany manufactureCompany){
        return repository.save(manufactureCompany);
    }
}
