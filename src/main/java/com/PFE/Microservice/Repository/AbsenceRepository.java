package com.PFE.Microservice.Repository;

import com.PFE.Microservice.Entity.Absence;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AbsenceRepository extends JpaRepository<Absence,Long> {

}
