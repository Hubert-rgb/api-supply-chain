package com.supplyChain.product.product;

import com.supplyChain.material.material.Material;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    public Product getProductById(long id){
        return repository.findById(id).orElse(null);
    }
    public List<Product> getAllProducts(){
        return repository.findAll();
    }
    public Product saveProduct(Product product){
        return repository.save(product);
    }

    public List<Product> getByUserId(long userId){
        return repository.findByUser_Id(userId);
    }
    public List<Product> getByCompanyId(long companyId){
        return repository.findByCompany_Id(companyId);
    }
    public List<Product> getByProductTypeId(long productTypeId){
        return repository.findByProductType_Id(productTypeId);
    }
}
