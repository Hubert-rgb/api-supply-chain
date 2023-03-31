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
    public List<ProductType> getAllProducts(){
        return repository.findAll();
    }
    public ProductType saveProductType(ProductType productType){
        return repository.save(productType);
    }
}
