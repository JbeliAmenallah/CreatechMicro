package com.PFE.Microservice.Repository;

import com.PFE.Microservice.Entity.Cotisation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CotisationRepository extends JpaRepository<Cotisation, Long> {
    List<Cotisation> findByContact_Name(String contactName);
}
