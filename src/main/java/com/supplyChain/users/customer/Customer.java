package com.supplyChain.users.customer;

import com.supplyChain.location.Address;
import com.supplyChain.orders.customerOrder.CustomerOrder;
import com.supplyChain.enumClasses.type.UserType;
import com.supplyChain.users.user.User;
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

    @OneToMany(mappedBy = "customer", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private List<CustomerOrder> customerOrders;

    public Customer(String name, UserType type){
        super(name, type);
    }
}
