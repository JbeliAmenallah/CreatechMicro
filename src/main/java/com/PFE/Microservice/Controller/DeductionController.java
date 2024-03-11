package com.PFE.Microservice.Controller;

import com.PFE.Microservice.DTO.DeductionDTO;
import com.PFE.Microservice.Entity.Deduction;
import com.PFE.Microservice.Services.DeductionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/deductions")
@RequiredArgsConstructor
public class DeductionController {

    private final DeductionService deductionService;

    @PostMapping
    public ResponseEntity<Deduction> createDeduction(@RequestBody DeductionDTO deductionDTO) {
        Deduction createdDeduction = deductionService.saveDeduction(deductionDTO);
        return new ResponseEntity<>(createdDeduction, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Deduction> getDeductionById(@PathVariable Long id) {
        return deductionService.getDeductionById(id)
                .map(deduction -> new ResponseEntity<>(deduction, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<Deduction>> getAllDeductions() {
        List<Deduction> deductions = deductionService.getAllDeductions();
        return new ResponseEntity<>(deductions, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDeduction(@PathVariable Long id) {
        deductionService.deleteDeductionById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
