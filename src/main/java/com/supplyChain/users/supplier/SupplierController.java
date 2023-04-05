package com.supplyChain.users.supplier;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
    @PostMapping()
    public Supplier createSupplier(@RequestBody JSONObject jsonInput){
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Supplier supplier = objectMapper.readValue(jsonInput.toJSONString(), Supplier.class);

            supplierService.saveSupplier(supplier);
            return supplier;
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
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
