package com.supplyChain.users.manufacturer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.supplyChain.users.distributor.Distributor;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/manufacturer")
@RestController
public class ManufacturerController {
    @Autowired
    ManufacturerService manufacturerService;
    @PostMapping()
    public Manufacturer createManufacturer(@RequestBody JSONObject jsonInput){
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Manufacturer manufacturer = objectMapper.readValue(jsonInput.toJSONString(), Manufacturer.class);

            manufacturerService.saveManufacturer(manufacturer);
            return manufacturer;
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
    @GetMapping("")
    public List<Manufacturer> getAllManufacturers(){
        return manufacturerService.getAllManufacturers();
    }

    @GetMapping("/{manufacturerId}")
    public Manufacturer getManufacturer(@PathVariable int manufacturerId){
        return manufacturerService.getManufacturerById(manufacturerId);
    }
}
