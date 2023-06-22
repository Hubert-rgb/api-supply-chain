package com.supplyChain.users.distributor;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/distributor")
public class DistributorController {
    @Autowired
    DistributorService distributorService;
    @PostMapping()
    public Distributor createDistributor(@RequestBody JSONObject jsonInput){
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Distributor distributor = objectMapper.readValue(jsonInput.toJSONString(), Distributor.class);

            distributorService.saveDistributor(distributor);
            return distributor;
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
    @GetMapping("")
    public List<Distributor> getAllDistributors(){
        return distributorService.getAllDistributors();
    }

    @GetMapping("/{distributorId}")
    public Distributor getDistributor(@PathVariable int distributorId){
        return distributorService.getDistributorById(distributorId);
    }
}
