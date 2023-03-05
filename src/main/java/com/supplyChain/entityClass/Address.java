package com.supplyChain.entityClass;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    private String countryName;
    private String city;
    private String street;
    private int houseNumber;
    private int postalCode;
    private String localNumber;

    public Address(String countryName, String city,
                   String street, int houseNumber, int postalCode, String localNumber){
        this.countryName = countryName;
        this.city = city;
        this.street = street;
        this.houseNumber = houseNumber;
        this.postalCode = postalCode;
        this.localNumber = localNumber;
    }
}
