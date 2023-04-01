package com.supplyChain.location;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {
    @Autowired
    private AddressRepository repository;

    public Address getAddressById(long id){
        return repository.findById(id).orElse(null);
    }
    public List<Address> getAllAddress(){
        return repository.findAll();
    }
    public Address saveAddress(Address address){
        return repository.save(address);
    }
}
