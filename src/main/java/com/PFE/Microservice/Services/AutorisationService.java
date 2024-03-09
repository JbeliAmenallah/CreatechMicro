package com.PFE.Microservice.Services;

import com.PFE.Microservice.DTO.AutorisationDTO;
import com.PFE.Microservice.Entity.Autorisation;
import com.PFE.Microservice.Entity.Contact;
import com.PFE.Microservice.Repository.AutorisationRepository;
import com.PFE.Microservice.Repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutorisationService {

    @Autowired
    private AutorisationRepository autorisationRepository;

    @Autowired
    private ContactRepository contactRepository;

    public Autorisation saveAutorisation(AutorisationDTO autorisationDTO) {
        Autorisation autorisation = new Autorisation();
        autorisation.setDate(autorisationDTO.getDate());
        Contact contact = contactRepository.findByName(autorisationDTO.getContactName());
        autorisation.setContact(contact);
        return autorisationRepository.save(autorisation);
    }

    public List<Autorisation> getAllAutorisations() {
        return autorisationRepository.findAll();
    }

    public Optional<Autorisation> getAutorisationById(Long id) {
        return autorisationRepository.findById(id);
    }

    public List<Autorisation> getAutorisationsByContactName(String contactName) {
        Contact contact = contactRepository.findByName(contactName);
        return autorisationRepository.findByContact_Name(contact.getName());
    }

    public Autorisation updateAutorisation(Long id, AutorisationDTO autorisationDTO) {
        Optional<Autorisation> optionalAutorisation = autorisationRepository.findById(id);

        if (optionalAutorisation.isPresent()) {
            Autorisation existingAutorisation = optionalAutorisation.get();
            existingAutorisation.setDate(autorisationDTO.getDate());
            Contact contact = contactRepository.findByName(autorisationDTO.getContactName());
            existingAutorisation.setContact(contact);
            return autorisationRepository.save(existingAutorisation);
        } else {
            // Handle not found scenario
            return null;
        }
    }

    public void deleteAutorisation(Long id) {
        autorisationRepository.deleteById(id);
    }
}
