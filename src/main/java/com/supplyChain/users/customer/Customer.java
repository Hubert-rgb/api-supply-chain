package com.supplyChain.users.customer;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.supplyChain.location.Address;
import com.supplyChain.orders.customerOrder.CustomerOrder;
import com.supplyChain.enumClasses.type.UserType;
import com.supplyChain.users.user.UserEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
//@PrimaryKeyJoinColumn()
public class Customer extends UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    /*@OneToMan
    private List<CustomerOrder> customerOrders;*/
    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @JoinColumn(name = "last_order_address_id")
    private Address lastOrderAddress = null;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @OneToMany(mappedBy = "customer", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private List<CustomerOrder> customerOrders = new ArrayList<>();

    public Customer(String name, UserType type){
        super(name, type);
    }
}
