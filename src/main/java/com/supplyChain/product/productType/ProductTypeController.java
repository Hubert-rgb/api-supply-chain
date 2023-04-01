package com.supplyChain.product.productType;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.supplyChain.company.manufactureCompany.ManufactureCompany;
import com.supplyChain.company.manufactureCompany.ManufactureCompanyService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("product_type")
public class ProductTypeController {
    @Autowired
    ProductTypeService productTypeService;

    @Autowired
    ManufactureCompanyService manufactureCompanyService;

    @PostMapping("/manufacture_company/{manufactureCompanyId}")
    public ProductType createProductType(@RequestBody JSONObject jsonInput, @PathVariable long manufactureCompanyId) {
        final ObjectMapper objectMapper = new ObjectMapper();
        try {
            ProductType productType = objectMapper.readValue(
                    jsonInput.toJSONString(), ProductType.class
            );
            ManufactureCompany manufactureCompany = manufactureCompanyService.getManufactureCompanyById(manufactureCompanyId);
            productType.setManufactureCompany(manufactureCompany);

            System.out.println(productType.getMaterialTypeIdQuantityToMake().get(1));
            productTypeService.saveProductType(productType);

            return productType;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @GetMapping("")
    public List<ProductType> getAllProductType(){
        return productTypeService.getAllProductTypes();
    }

    @GetMapping("/{materialTypeId}")
    public ProductType getProductType(@PathVariable long productTypeId){
        return productTypeService.getProductTypeById(productTypeId);
    }
    @GetMapping("/manufacture_company/{manufactureCompanyId}")
    public List<ProductType> getMaterialTypesByManufactureCompanyId(@PathVariable long manufactureCompanyId){
        return productTypeService.getByManufactureCompanyId(manufactureCompanyId);
    }
}
