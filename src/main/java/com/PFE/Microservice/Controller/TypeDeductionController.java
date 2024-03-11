package com.PFE.Microservice.Controller;

import com.PFE.Microservice.DTO.TypeDeductionDTO;
import com.PFE.Microservice.Entity.TypeDeduction;
import com.PFE.Microservice.Services.TypeDeductionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/typedeductions")
@RequiredArgsConstructor
public class    TypeDeductionController {

    private final TypeDeductionService typeDeductionService;

    @PostMapping
    public ResponseEntity<TypeDeduction> createTypeDeduction(@RequestBody TypeDeductionDTO typeDeductionDTO) {
        TypeDeduction createdTypeDeduction = typeDeductionService.saveTypeDeduction(typeDeductionDTO);
        return new ResponseEntity<>(createdTypeDeduction, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TypeDeduction> getTypeDeductionById(@PathVariable Long id) {
        return typeDeductionService.getTypeDeductionById(id)
                .map(typeDeduction -> new ResponseEntity<>(typeDeduction, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<TypeDeduction>> getAllTypeDeductions() {
        List<TypeDeduction> typeDeductions = typeDeductionService.getAllTypeDeductions();
        return new ResponseEntity<>(typeDeductions, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTypeDeduction(@PathVariable Long id) {
        typeDeductionService.deleteTypeDeductionById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
