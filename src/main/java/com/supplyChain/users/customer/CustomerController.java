package com.supplyChain.users.customer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    CustomerService customerService;
    @PostMapping()
    public Customer createCustomer(@RequestBody JSONObject jsonInput){
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Customer customer = objectMapper.readValue(jsonInput.toJSONString(), Customer.class);

            customerService.saveCustomer(customer);
            return customer;
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
    @GetMapping("")
    public List<Customer> getAllCustomers(){
        return customerService.getAllCustomers();
    }

    @GetMapping("/{customerId}")
    public Customer getCustomer(@PathVariable int customerId){
        return customerService.getCustomerById(customerId);
    }
}
