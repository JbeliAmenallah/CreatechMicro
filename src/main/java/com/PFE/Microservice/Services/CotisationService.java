package com.PFE.Microservice.Services;

import com.PFE.Microservice.DTO.CotisationDTO;
import com.PFE.Microservice.Entity.Cotisation;
import com.PFE.Microservice.Entity.Contact;
import com.PFE.Microservice.Repository.CotisationRepository;
import com.PFE.Microservice.Repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CotisationService {

    @Autowired
    private CotisationRepository cotisationRepository;

    @Autowired
    private ContactRepository contactRepository;

    public Cotisation saveCotisation(CotisationDTO cotisationDTO) {
        Cotisation cotisation = new Cotisation();
        cotisation.setLibele(cotisationDTO.getLibele());
        cotisation.setTaux(cotisationDTO.getTaux());
        cotisation.setAnnee(cotisationDTO.getAnnee());
        Contact contact = contactRepository.findByName(cotisationDTO.getContactName());
        cotisation.setContact(contact);
        return cotisationRepository.save(cotisation);
    }

    public List<Cotisation> getAllCotisations() {
        return cotisationRepository.findAll();
    }

    public Optional<Cotisation> getCotisationById(Long id) {
        return cotisationRepository.findById(id);
    }

    public List<Cotisation> getCotisationsByContactName(String contactName) {
        Contact contact = contactRepository.findByName(contactName);
        return cotisationRepository.findByContact_Name(contact.getName());
    }

    public Cotisation updateCotisation(Long id, CotisationDTO cotisationDTO) {
        Optional<Cotisation> optionalCotisation = cotisationRepository.findById(id);

        if (optionalCotisation.isPresent()) {
            Cotisation existingCotisation = optionalCotisation.get();
            existingCotisation.setLibele(cotisationDTO.getLibele());
            existingCotisation.setTaux(cotisationDTO.getTaux());
            existingCotisation.setAnnee(cotisationDTO.getAnnee());
            Contact contact = contactRepository.findByName(cotisationDTO.getContactName());
            existingCotisation.setContact(contact);
            return cotisationRepository.save(existingCotisation);
        } else {
            // Handle not found scenario
            return null;
        }
    }

    public void deleteCotisation(Long id) {
        cotisationRepository.deleteById(id);
    }
}
