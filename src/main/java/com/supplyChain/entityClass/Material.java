package com.supplyChain.entityClass;

import com.supplyChain.entityClass.users.Supplier;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Material {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    private float price;
    private String name;
    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;

    public Material(String name, float price, Supplier supplier){
        this.name = name;
        this.price = price;
        this.supplier = supplier;
    }
}
