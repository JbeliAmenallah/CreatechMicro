package com.PFE.Microservice.Repository;

import com.PFE.Microservice.Entity.Conges;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CongesRepository extends JpaRepository<Conges,Long> {
    // Custom query to find Conges by Contact name
    List<Conges> findByContact_Name(String contactName);
    List<Conges> findByState(String state);
}
