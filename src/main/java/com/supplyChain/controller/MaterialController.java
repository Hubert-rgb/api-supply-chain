package com.supplyChain.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.supplyChain.entityClass.Material;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@Controller
//@RequestMapping("/material")
public class MaterialController {
    //@PostMapping("/supplier/{supplierId}")
    @PostMapping("")
    public Material createMaterialType(@RequestBody JSONObject jsonInput, @RequestAttribute int supplierId) {
        final ObjectMapper objectMapper = new ObjectMapper();
        try {
            Material material = objectMapper.readValue(jsonInput.toJSONString(), Material.class);
            return material;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
