package com.meli.projetointegradorgroup1.repository;

import com.meli.projetointegradorgroup1.entity.Representante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface RepresentativeRepository extends JpaRepository<Representante, Long>{
    Optional<Representante> findById(Long Id);

}