package com.PFE.Microservice.Controller;

import com.PFE.Microservice.DTO.TypePrimeDTO;
import com.PFE.Microservice.Entity.TypePrime;
import com.PFE.Microservice.Services.TypePrimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/typeprime")
public class TypePrimeController {

    @Autowired
    private TypePrimeService typePrimeService;

    @PostMapping
    public TypePrime createTypePrime(@RequestBody TypePrimeDTO typePrimeDTO) {
        return typePrimeService.saveTypePrime(typePrimeDTO);
    }

    @GetMapping
    public List<TypePrime> getAllTypePrimes() {
        return typePrimeService.getAllTypePrimes();
    }

    @GetMapping("/{id}")
    public TypePrime getTypePrimeById(@PathVariable Long id) {
        return typePrimeService.getTypePrimeById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public TypePrime updateTypePrime(@PathVariable Long id, @RequestBody TypePrimeDTO typePrimeDTO) {
        return typePrimeService.updateTypePrime(id, typePrimeDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteTypePrime(@PathVariable Long id) {
        typePrimeService.deleteTypePrime(id);
    }
}
