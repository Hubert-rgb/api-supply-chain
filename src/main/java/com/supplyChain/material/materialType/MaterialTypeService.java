package com.supplyChain.material.materialType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialTypeService {
    @Autowired
    private MaterialTypeRepository repository;

    public MaterialType getMaterialTypeById(long id){
        return repository.findById(id).orElse(null);
    }
    public List<MaterialType> getAllMaterialTypes(){
        return repository.findAll();
    }
    public MaterialType saveMaterialType(MaterialType materialType){
        return repository.save(materialType);
    }

    public List<MaterialType> getMaterialTypesBySupplierCompanyId(long supplierCompanyId){
        return repository.findBySupplierCompany_Id(supplierCompanyId);
    }
}
