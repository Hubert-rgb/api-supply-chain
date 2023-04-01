package com.supplyChain.material.material;

import com.supplyChain.material.materialType.MaterialType;
import com.supplyChain.material.materialType.MaterialTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialService {
    @Autowired
    private MaterialRepository repository;

    public Material getMaterialById(long id){
        return repository.findById(id).orElse(null);
    }
    public List<Material> getAllMaterial(){
        return repository.findAll();
    }
    public Material saveMaterial(Material material){
        return repository.save(material);
    }

    public List<Material> getByUserId(long userId){
        return repository.findByUser_Id(userId);
    }
    public List<Material> getByCompanyId(long companyId){
        return repository.findByCompany_Id(companyId);
    }
    public List<Material> getByMaterialTypeId(long materialTypeId){
        return repository.findByMaterialType_Id(materialTypeId);
    }
}
