package com.supplyChain.users.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository repository;

    public Customer getCustomerById(long id){
        return repository.findById(id).orElse(null);
    }
    public List<Customer> getAllCustomers(){
        return repository.findAll();
    }
    public Customer saveCustomer(Customer customer){
        return repository.save(customer);
    }
}
