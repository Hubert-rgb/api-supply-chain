package com.supplyChain.company.distributionCompany;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.supplyChain.company.supplierCompany.SupplierCompany;
import com.supplyChain.location.AddressService;
import com.supplyChain.material.materialType.MaterialType;
import jakarta.persistence.Access;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/distribution_company")
public class DistributionCompanyController {
    @Autowired
    DistributionCompanyService distributionCompanyService;

    @Autowired
    AddressService addressService;

    @PostMapping
    public DistributionCompany createDistributionCompany(@RequestBody JSONObject jsonInput){
        final ObjectMapper objectMapper = new ObjectMapper();
        try {
            DistributionCompany distributionCompany = objectMapper.readValue(
                    jsonInput.toJSONString(), DistributionCompany.class
            );

            addressService.saveAddress(distributionCompany.getAddress());
            distributionCompanyService.saveDistributionCompany(distributionCompany);
            return distributionCompany;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @GetMapping
    public List<DistributionCompany> getAllDistributionCompany(){
        return distributionCompanyService.getAllDistributionCompany();
    }

    @GetMapping("/{companyId}")
    public DistributionCompany getDistributionCompanyById(@PathVariable long companyId){
        return distributionCompanyService.getDistributionCompanyById(companyId);
    }
}
