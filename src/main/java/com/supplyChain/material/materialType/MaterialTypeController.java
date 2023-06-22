package com.supplyChain.material.materialType;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.supplyChain.company.supplierCompany.SupplierCompany;
import com.supplyChain.company.supplierCompany.SupplierCompanyRepository;
import com.supplyChain.company.supplierCompany.SupplierCompanyService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@Controller
@RequestMapping("/material_type")
public class MaterialTypeController {
    @Autowired
    MaterialTypeService materialTypeService;

    @Autowired
    SupplierCompanyService supplierCompanyService;

    @PostMapping("/supplier_company/{supplierCompanyId}")
    public MaterialType createMaterialType(@RequestBody JSONObject jsonInput, @PathVariable long supplierCompanyId) {
        final ObjectMapper objectMapper = new ObjectMapper();
        try {
            MaterialType materialType = objectMapper.readValue(
                    jsonInput.toJSONString(), MaterialType.class
            );
            SupplierCompany supplierCompany = supplierCompanyService.getSupplierCompanyById(supplierCompanyId);
            materialType.assignSupplierCompany(supplierCompany);
            materialTypeService.saveMaterialType(materialType);

            return materialType;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @GetMapping("")
    public List<MaterialType> getAllMaterialType(){
        return materialTypeService.getAllMaterialTypes();
    }

    @GetMapping("/{materialTypeId}")
    public MaterialType getMaterialType(@PathVariable long materialTypeId){
        return materialTypeService.getMaterialTypeById(materialTypeId);
    }
    @GetMapping("/supplier_company/{supplierCompanyId}")
    public List<MaterialType> getMaterialTypesBySupplierCompanyId(@PathVariable long supplierCompanyId){
        return materialTypeService.getMaterialTypesBySupplierCompanyId(supplierCompanyId);
    }
}
