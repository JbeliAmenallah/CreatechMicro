package com.PFE.Microservice.Services;

import com.PFE.Microservice.DTO.TypePrimeDTO;
import com.PFE.Microservice.Entity.TypePrime;
import com.PFE.Microservice.Mapper.TypePrimeMapper;
import com.PFE.Microservice.Repository.TypePrimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TypePrimeService {

    @Autowired
    private TypePrimeRepository typePrimeRepository;

    public TypePrime saveTypePrime(TypePrimeDTO typePrimeDTO) {
        TypePrime typePrime = new TypePrime();

        // Set attributes manually
        typePrime.setCode(typePrimeDTO.getCode());
        typePrime.setLibele(typePrimeDTO.getLibele());
        typePrime.setCnss(typePrimeDTO.getCnss());
        typePrime.setImpo(typePrimeDTO.getImpo());
        typePrime.setMontant(typePrimeDTO.getMontant());
        typePrime.setType(typePrimeDTO.getType());
        return typePrimeRepository.save(typePrime);
    }

    public List<TypePrime> getAllTypePrimes() {
        return typePrimeRepository.findAll();
    }

    public Optional<TypePrime> getTypePrimeById(Long id) {
        return typePrimeRepository.findById(id);
    }

    public TypePrime updateTypePrime(Long id, TypePrimeDTO typePrimeDTO) {
        Optional<TypePrime> optionalTypePrime = typePrimeRepository.findById(id);

        if (optionalTypePrime.isPresent()) {
            TypePrime existingTypePrime = optionalTypePrime.get();
            existingTypePrime.setCode(typePrimeDTO.getCode());
            existingTypePrime.setLibele(typePrimeDTO.getLibele());
            existingTypePrime.setCnss(typePrimeDTO.getCnss());
            existingTypePrime.setImpo(typePrimeDTO.getImpo());
            existingTypePrime.setMontant(typePrimeDTO.getMontant());
            existingTypePrime.setType(typePrimeDTO.getType());
            return typePrimeRepository.save(existingTypePrime);
        } else {
            // Handle not found scenario
            return null;
        }
    }

    public void deleteTypePrime(Long id) {
        typePrimeRepository.deleteById(id);
    }
}
