package com.PFE.Microservice.Services;

import com.PFE.Microservice.DTO.PrimeDTO;
import com.PFE.Microservice.Entity.Contact;
import com.PFE.Microservice.Entity.Prime;
import com.PFE.Microservice.Entity.TypePrime;
import com.PFE.Microservice.Repository.ContactRepository;
import com.PFE.Microservice.Repository.PrimeRepository;
import com.PFE.Microservice.Repository.TypePrimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PrimeService {

    @Autowired
    private PrimeRepository primeRepository;

    @Autowired
    private TypePrimeRepository typePrimeRepository;

    @Autowired
    private ContactRepository contactRepository;

    public Prime savePrime(PrimeDTO primeDTO) {
        Prime prime = new Prime();
        prime.setTypePrime(typePrimeRepository.findById(primeDTO.getTypePrimeId()).orElse(null));
        prime.setContact(contactRepository.findById(primeDTO.getContactId()).orElse(null));
        prime.setYear(primeDTO.getYear());
        prime.setMonth(primeDTO.getMonth());
        prime.setMontant(primeDTO.getMontant());
        prime.setMotif(primeDTO.getMotif());
        return primeRepository.save(prime);
    }
    public List<Prime> getAllPrimes() {
        return primeRepository.findAll();
    }

    public Optional<Prime> getPrimeById(Long id) {
        return primeRepository.findById(id);
    }

    public Prime updatePrime(Long id, PrimeDTO primeDTO) {
        Optional<Prime> primeOptional = primeRepository.findById(id);
        if (primeOptional.isPresent()) {
            Prime prime = primeOptional.get();
            prime.setTypePrime(typePrimeRepository.findById(primeDTO.getTypePrimeId()).orElse(null));
            prime.setContact(contactRepository.findById(primeDTO.getContactId()).orElse(null));
            prime.setYear(primeDTO.getYear());
            prime.setMonth(primeDTO.getMonth());
            prime.setMontant(primeDTO.getMontant());
            prime.setMotif(primeDTO.getMotif());
            return primeRepository.save(prime);
        }
        return null;
    }

    public boolean deletePrimeById(Long id) {
        Optional<Prime> primeOptional = primeRepository.findById(id);
        if (primeOptional.isPresent()) {
            primeRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
