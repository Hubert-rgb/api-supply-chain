package com.supplyChain.company.supplierCompany;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierCompanyService {
    @Autowired
    private SupplierCompanyRepository repository;

    public SupplierCompany getSupplierCompanyById(long id){
        return repository.findById(id).orElse(null);
    }
    public List<SupplierCompany> getAllSupplierCompany(){
        return repository.findAll();
    }
    public SupplierCompany saveSupplierCompany(SupplierCompany supplierCompany){
        return repository.save(supplierCompany);
    }
}
