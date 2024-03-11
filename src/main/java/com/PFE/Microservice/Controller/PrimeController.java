package com.PFE.Microservice.Controller;

import com.PFE.Microservice.DTO.PrimeDTO;
import com.PFE.Microservice.Entity.Prime;
import com.PFE.Microservice.Services.PrimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/prime")
public class PrimeController {

    @Autowired
    private PrimeService primeService;

    @PostMapping("/add")
    public ResponseEntity<Prime> addPrime(@RequestBody PrimeDTO primeDTO) {
        Prime prime = primeService.savePrime(primeDTO);
        return new ResponseEntity<>(prime, HttpStatus.CREATED);
    }

    @GetMapping("/retrieve")
    public ResponseEntity<List<Prime>> getAllPrimes() {
        List<Prime> primes = primeService.getAllPrimes();
        return new ResponseEntity<>(primes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Prime> getPrimeById(@PathVariable Long id) {
        Optional<Prime> primeOptional = primeService.getPrimeById(id);
        return primeOptional.map(prime -> new ResponseEntity<>(prime, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Prime> updatePrime(@PathVariable Long id, @RequestBody PrimeDTO primeDTO) {
        Prime updatedPrime = primeService.updatePrime(id, primeDTO);
        if (updatedPrime != null) {
            return new ResponseEntity<>(updatedPrime, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletePrime(@PathVariable Long id) {
        if (primeService.deletePrimeById(id)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
