package com.supplyChain.users.customer;

import com.supplyChain.users.user.UserRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends UserRepository<Customer> {
}