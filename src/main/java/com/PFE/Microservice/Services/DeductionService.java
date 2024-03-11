package com.PFE.Microservice.Services;

import com.PFE.Microservice.DTO.DeductionDTO;
import com.PFE.Microservice.Entity.Contact;
import com.PFE.Microservice.Entity.Deduction;
import com.PFE.Microservice.Entity.TypeDeduction;
import com.PFE.Microservice.Repository.ContactRepository;
import com.PFE.Microservice.Repository.DeductionRepository;
import com.PFE.Microservice.Repository.TypeDeductionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeductionService {

    private final DeductionRepository deductionRepository;
    private final TypeDeductionRepository typeDeductionRepository;
    private final ContactRepository contactRepository;

    @Autowired
    public DeductionService(DeductionRepository deductionRepository, TypeDeductionRepository typeDeductionRepository,
                            ContactRepository contactRepository) {
        this.deductionRepository = deductionRepository;
        this.typeDeductionRepository = typeDeductionRepository;
        this.contactRepository = contactRepository;
    }

    public List<Deduction> getAllDeductions() {
        return deductionRepository.findAll();
    }

    public Optional<Deduction> getDeductionById(Long id) {
        return deductionRepository.findById(id);
    }

    public Deduction saveDeduction(DeductionDTO deductionDTO) {
        Deduction deduction = new Deduction();
        deduction.setAnnee(deductionDTO.getAnnee());
        deduction.setSalaire(deductionDTO.getSalaire());
        deduction.setMontant(deductionDTO.getMontant());
        deduction.setNombre(deductionDTO.getNombre());

        // Fetch TypeDeduction by ref and set to Deduction
        TypeDeduction typeDeduction = typeDeductionRepository.findByRef(deductionDTO.getRef())
                .orElseThrow(() -> new RuntimeException("TypeDeduction not found with ref: " + deductionDTO.getRef()));
        deduction.setTypeDeduction(typeDeduction);

        // Fetch Contact by contactId and set to Deduction
        Contact contact = contactRepository.findById(deductionDTO.getContactId())
                .orElseThrow(() -> new RuntimeException("Contact not found with id: " + deductionDTO.getContactId()));
        deduction.setContact(contact);

        return deductionRepository.save(deduction);
    }

    public void deleteDeductionById(Long id) {
        deductionRepository.deleteById(id);
    }
}
