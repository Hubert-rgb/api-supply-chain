package com.supplyChain.product.productType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductTypeService {
    @Autowired
    private ProductTypeRepository repository;

    public ProductType getProductTypeById(long id){
        return repository.findById(id).orElse(null);
    }
    public List<ProductType> getAllProductTypes(){
        return repository.findAll();
    }
    public void saveProductType(ProductType productType){
        repository.save(productType);
    }

    public List<ProductType> getByManufactureCompanyId(long manufactureCompanyId){
        return repository.findByManufactureCompany_Id(manufactureCompanyId);
    }
}
