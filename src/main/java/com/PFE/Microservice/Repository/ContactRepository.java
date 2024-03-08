package com.PFE.Microservice.Repository;

import com.PFE.Microservice.Entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact,Long> {
    Contact findByName(String name);
}
