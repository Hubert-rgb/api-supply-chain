package com.supplyChain.users.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface UserRepository<T extends UserEntity> extends JpaRepository<T, Long> {
}
