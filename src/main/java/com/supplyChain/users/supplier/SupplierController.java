package com.supplyChain.users.supplier;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsontype.BasicPolymorphicTypeValidator;
import com.fasterxml.jackson.databind.jsontype.PolymorphicTypeValidator;
import com.supplyChain.company.supplierCompany.SupplierCompany;
import com.supplyChain.company.supplierCompany.SupplierCompanyService;
import com.supplyChain.users.distributor.Distributor;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/supplier")
@RestController
public class SupplierController {
    @Autowired
    SupplierService supplierService;

    @Autowired
    SupplierCompanyService supplierCompanyService;

    @PostMapping()
    public Supplier createSupplier(@RequestBody JSONObject jsonInput){
        PolymorphicTypeValidator polymorphicTypeValidator = BasicPolymorphicTypeValidator.builder().build();

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.activateDefaultTyping(polymorphicTypeValidator, ObjectMapper.DefaultTyping.NON_FINAL);
        try {
            Supplier supplier = objectMapper.readValue(jsonInput.toJSONString(), Supplier.class);

            supplierService.saveSupplier(supplier);
            return supplier;
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
    @PostMapping("/supplier1")
    public boolean createSupplier1(){
        Supplier supplier = new Supplier("name1");

        SupplierCompany supplierCompany = new SupplierCompany();
        supplierCompanyService.saveSupplierCompany(supplierCompany);

        supplier.setSupplierCompany(supplierCompany);
        supplierService.saveSupplier(supplier);

        return supplierService.getSuppliersByCompany(supplierCompany.getId()).get(0) == supplier;
    }
    @GetMapping("")
    public List<Supplier> getAllSuppliers(){
        return supplierService.getAllSuppliers();
    }

    @GetMapping("/{supplierId}")
    public Supplier getSupplier(@PathVariable int supplierId){
        return supplierService.getSupplierById(supplierId);
    }
}
