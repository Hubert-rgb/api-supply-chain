package com.supplyChain.company.company;

import com.supplyChain.location.Address;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;

    public Company(String name, String street, String city, String countryName, int houseNumber, int postalCode, String localNumber){
        this.name = name;
        this.address = new Address(countryName, city, street, houseNumber, postalCode, localNumber);
    }
}
