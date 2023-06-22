package com.supplyChain.users.manufacturer;

import com.supplyChain.users.distributor.Distributor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManufacturerService {
    @Autowired
    private ManufacturerRepository repository;

    public Manufacturer getManufacturerById(long id){
        return repository.findById(id).orElse(null);
    }
    public List<Manufacturer> getAllManufacturers(){
        return repository.findAll();
    }
    public Manufacturer saveManufacturer(Manufacturer manufacturer){
        return repository.save(manufacturer);
    }

    public List<Manufacturer> getManufacturersByCompany(long companyId){
        return repository.findByManufactureCompany_Id(companyId);
    }
}
