package com.supplyChain.service;

import com.supplyChain.entityClass.users.User;
import com.supplyChain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public User getUser(int id){
        return repository.findById(id).orElse(null);
    }
    public User saveUser(User user){
        return repository.save(user);
    }
}
