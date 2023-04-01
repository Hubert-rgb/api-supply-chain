package com.supplyChain.product.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("select p from Product p where p.user.id = ?1")
    List<Product> findByUser_Id(Long id);

    @Query("select p from Product p where p.company.id = ?1")
    List<Product> findByCompany_Id(Long id);

    @Query("select p from Product p where p.productType.id = ?1")
    List<Product> findByProductType_Id(Long id);
}
