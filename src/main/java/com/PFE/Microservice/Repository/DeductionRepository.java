package com.PFE.Microservice.Repository;

import com.PFE.Microservice.Entity.Deduction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeductionRepository extends JpaRepository<Deduction, Long> {
}
