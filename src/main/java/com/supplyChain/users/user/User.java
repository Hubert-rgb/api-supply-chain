package com.supplyChain.users.user;

import com.supplyChain.enumClasses.type.UserType;
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
public abstract class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    private UserType type;

    public User(String name, UserType type){
        this.name = name;
        this.type = type;
    }
}