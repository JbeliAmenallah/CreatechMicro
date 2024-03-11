package com.PFE.Microservice.Services;

import com.PFE.Microservice.DTO.TypeDeductionDTO;
import com.PFE.Microservice.Entity.TypeDeduction;
import com.PFE.Microservice.Mapper.TypeDeductionMapper;
import com.PFE.Microservice.Repository.TypeDeductionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TypeDeductionService {

    private final TypeDeductionRepository typeDeductionRepository;

    @Autowired
    public TypeDeductionService(TypeDeductionRepository typeDeductionRepository) {
        this.typeDeductionRepository = typeDeductionRepository;
    }

    public List<TypeDeduction> getAllTypeDeductions() {
        return typeDeductionRepository.findAll();
    }

    public Optional<TypeDeduction> getTypeDeductionById(Long id) {
        return typeDeductionRepository.findById(id);
    }

    public TypeDeduction saveTypeDeduction(TypeDeductionDTO typeDeductionDTO) {
        TypeDeduction typeDeduction = new TypeDeduction();
        typeDeduction.setRef(typeDeductionDTO.getRef());
        typeDeduction.setDesignation(typeDeductionDTO.getDesignation());
        typeDeduction.setCommune(typeDeductionDTO.getCommune());
        typeDeduction.setMontant(typeDeductionDTO.getMontant());
        typeDeduction.setPourcentage(typeDeductionDTO.getPourcentage());
        return typeDeductionRepository.save(typeDeduction);
    }

    public void deleteTypeDeductionById(Long id) {
        typeDeductionRepository.deleteById(id);
    }
}
