package com.supplyChain.material.material;

import com.supplyChain.material.materialType.MaterialType;
import com.supplyChain.material.materialType.MaterialTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/material")
public class MaterialController {
    @Autowired
    MaterialTypeService materialTypeService;

    @Autowired
    MaterialService materialService;

    //TODO it's incomplete
    @PostMapping("/user/{userId}/company/{companyId}/material_type/{materialTypeId}")
    public Material createMaterial(@PathVariable long userId, @PathVariable long companyId, @PathVariable long materialTypeId){
        Material material = new Material();

        MaterialType materialType = materialTypeService.getMaterialTypeById(materialTypeId);

        material.setMaterialType(materialType);

        materialService.saveMaterial(material);
        return material;
    }

    @GetMapping("")
    public List<Material> getAllMaterials(){
        return materialService.getAllMaterial();
    }

    @GetMapping("/{materialTypeId}")
    public Material getMaterial(@PathVariable long materialId){
        return materialService.getMaterialById(materialId);
    }
    @GetMapping("/company/{companyId}")
    public List<Material> getMaterialByCompanyId(@PathVariable long companyId){
        return materialService.getByCompanyId(companyId);
    }
    @GetMapping("/user/{userId}")
    public List<Material> getMaterialByUserId(@PathVariable long userId){
        return materialService.getByUserId(userId);
    }

    @GetMapping("/material_type/{materialTypeId}")
    public List<Material> getMaterialByMaterialTypeId(@PathVariable long materialTypeId){
        return materialService.getByMaterialTypeId(materialTypeId);
    }
}
