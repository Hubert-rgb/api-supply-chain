package com.supplyChain.material.materialType;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@Controller
@RequestMapping("/material_type")
public class MaterialTypeController {
    //@PostMapping("/supplier/{supplierId}")
    @PostMapping("/mi/{supplierId}")
    public MaterialType createMaterialType(@RequestBody JSONObject jsonInput, @PathVariable int supplierId) {
        final ObjectMapper objectMapper = new ObjectMapper();
        try {
            MaterialType materialType = objectMapper.readValue(jsonInput.toJSONString(), MaterialType.class);
            return materialType;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
