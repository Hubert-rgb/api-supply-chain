package com.supplyChain.users.user;

import com.supplyChain.enumClasses.type.UserType;
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
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class UserEntity {
    @Id
    private Long id;
    private String name;
    @Enumerated
    private UserType type;

    public UserEntity(String name, UserType type){
        this.name = name;
        this.type = type;
    }
}
