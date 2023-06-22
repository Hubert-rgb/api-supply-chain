package com.supplyChain.company.manufactureCompany;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.supplyChain.location.AddressService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/manufacture_company")
public class ManufactureCompanyController {
    @Autowired
    ManufactureCompanyService manufactureCompanyService;

    @Autowired
    AddressService addressService;

    @PostMapping
    public ManufactureCompany createManufactureCompany(@RequestBody JSONObject jsonInput){
        final ObjectMapper objectMapper = new ObjectMapper();
        try {
            ManufactureCompany manufactureCompany = objectMapper.readValue(
                    jsonInput.toJSONString(), ManufactureCompany.class
            );

            addressService.saveAddress(manufactureCompany.getAddress());
            manufactureCompanyService.saveManufactureCompany(manufactureCompany);
            return manufactureCompany;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @GetMapping
    public List<ManufactureCompany> getAllManufactureCompany(){
        return manufactureCompanyService.getAllManufactureCompany();
    }

    @GetMapping("/{companyId}")
    public ManufactureCompany getManufactureCompanyById(@PathVariable long companyId){
        return manufactureCompanyService.getManufactureCompanyById(companyId);
    }
}
