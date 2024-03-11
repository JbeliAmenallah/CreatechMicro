package com.PFE.Microservice.Repository;

import com.PFE.Microservice.Entity.TypeDeduction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TypeDeductionRepository extends JpaRepository<TypeDeduction,Long> {
    Optional<TypeDeduction> findByRef(String ref);

}
