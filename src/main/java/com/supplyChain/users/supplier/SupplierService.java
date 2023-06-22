package com.supplyChain.users.supplier;

import com.supplyChain.users.distributor.Distributor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierService {
    @Autowired
    private SupplierRepository repository;

    public Supplier getSupplierById(long id){
        return repository.findById(id).orElse(null);
    }
    public List<Supplier> getAllSuppliers(){
        return repository.findAll();
    }
    public Supplier saveSupplier(Supplier supplier){
        return repository.save(supplier);
    }
    public List<Supplier> getSuppliersByCompany(long companyId){
        return repository.findBySupplierCompany_Id(companyId);
    }
}
