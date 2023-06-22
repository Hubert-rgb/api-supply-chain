package com.supplyChain.company.supplierCompany;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.supplyChain.company.manufactureCompany.ManufactureCompany;
import com.supplyChain.location.AddressService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("supplier_company")
public class SupplierCompanyController {
    @Autowired
    SupplierCompanyService supplierCompanyService;

    @Autowired
    AddressService addressService;

    @PostMapping
    public SupplierCompany createSupplierCompany(@RequestBody JSONObject jsonInput){
        final ObjectMapper objectMapper = new ObjectMapper();
        try {
            SupplierCompany supplierCompany = objectMapper.readValue(
                    jsonInput.toJSONString(), SupplierCompany.class
            );

            addressService.saveAddress(supplierCompany.getAddress());
            supplierCompanyService.saveSupplierCompany(supplierCompany);
            return supplierCompany;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @GetMapping
    public List<SupplierCompany> getAllSupplierCompany(){
        return supplierCompanyService.getAllSupplierCompany();
    }

    @GetMapping("/{companyId}")
    public SupplierCompany getSupplierCompanyById(@PathVariable long companyId){
        return supplierCompanyService.getSupplierCompanyById(companyId);
    }
}
