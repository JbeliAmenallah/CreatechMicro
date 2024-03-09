package com.PFE.Microservice.Services;

import com.PFE.Microservice.DTO.CongesDTO;
import com.PFE.Microservice.Entity.Conges;
import com.PFE.Microservice.Entity.Contact;
import com.PFE.Microservice.Repository.CongesRepository;
import com.PFE.Microservice.Repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CongesService {

    @Autowired
    private CongesRepository congesRepository;

    @Autowired
    private ContactRepository contactRepository;

    public Conges saveConges(CongesDTO congesDTO) {
        Conges conges = new Conges();
        conges.setStartDate(congesDTO.getStartDate());
        conges.setEndDate(congesDTO.getEndDate());
        conges.setState(congesDTO.getState());
        Contact contact = contactRepository.findByName(congesDTO.getContactName());
        conges.setContact(contact);
        return congesRepository.save(conges);
    }

    public List<Conges> getAllConges() {
        return congesRepository.findAll();
    }

    public Optional<Conges> getCongesById(Long id) {
        return congesRepository.findById(id);
    }

    public List<Conges> getCongesByContactName(String contactName) {
        Contact contact = contactRepository.findByName(contactName);
        return congesRepository.findByContact_Name(contact.getName());
    }
    public List<Conges> getCongesByState(String state) {
        return congesRepository.findByState(state);
    }
    public Conges updateConges(Long id, CongesDTO congesDTO) {
        Optional<Conges> optionalConges = congesRepository.findById(id);

        if (optionalConges.isPresent()) {
            Conges existingConges = optionalConges.get();
            existingConges.setStartDate(congesDTO.getStartDate());
            existingConges.setEndDate(congesDTO.getEndDate());
            existingConges.setState(congesDTO.getState());
            Contact contact = contactRepository.findByName(congesDTO.getContactName());
            existingConges.setContact(contact);
            return congesRepository.save(existingConges);
        } else {
            // Handle not found scenario
            return null;
        }
    }

    public void deleteConges(Long id) {
        congesRepository.deleteById(id);
    }
}
