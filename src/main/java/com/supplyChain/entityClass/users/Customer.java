package com.supplyChain.entityClass.users;

import com.supplyChain.entityClass.Address;
import com.supplyChain.entityClass.orders.CustomerOrder;
import com.supplyChain.type.UserType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
//@PrimaryKeyJoinColumn()
public class Customer extends User {

    /*@OneToMan
    private List<CustomerOrder> customerOrders;*/
    @ManyToOne
    @JoinColumn(name = "last_order_address_id")
    private Address lastOrderAddress;
    public Customer(String name, UserType type){
        super(name, type);
    }
}
