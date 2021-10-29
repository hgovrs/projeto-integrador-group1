package com.meli.projetointegradorgroup1.repository;

import com.meli.projetointegradorgroup1.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    public Iterable<Product> findByProductNameContaining(String productName);

}
