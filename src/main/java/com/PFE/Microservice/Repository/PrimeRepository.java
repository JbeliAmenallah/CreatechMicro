package com.PFE.Microservice.Repository;

import com.PFE.Microservice.Entity.Prime;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrimeRepository extends JpaRepository<Prime,Long> {
}
