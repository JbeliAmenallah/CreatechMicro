package com.PFE.Microservice.Repository;

import com.PFE.Microservice.Entity.Autorisation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AutorisationRepository extends JpaRepository<Autorisation,Long> {
    List<Autorisation> findByContact_Name(String name);
    //add new used methods
}
