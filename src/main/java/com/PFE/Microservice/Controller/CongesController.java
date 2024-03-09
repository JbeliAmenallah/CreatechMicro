package com.PFE.Microservice.Controller;

import com.PFE.Microservice.DTO.CongesDTO;
import com.PFE.Microservice.Entity.Conges;
import com.PFE.Microservice.Services.CongesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/conges")
public class CongesController {

    @Autowired
    private CongesService congesService;

    @PostMapping("/add")
    public ResponseEntity<Conges> addConges(@RequestBody CongesDTO congesDTO) {
        Conges savedConges = congesService.saveConges(congesDTO);
        return new ResponseEntity<>(savedConges, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Conges>> getAllConges() {
        List<Conges> congesList = congesService.getAllConges();
        return new ResponseEntity<>(congesList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Conges> getCongesById(@PathVariable Long id) {
        Optional<Conges> conges = congesService.getCongesById(id);
        return conges.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/by-contact/{contactName}")
    public ResponseEntity<List<Conges>> getCongesByContactName(@PathVariable String contactName) {
        List<Conges> congesList = congesService.getCongesByContactName(contactName);
        return new ResponseEntity<>(congesList, HttpStatus.OK);
    }
    @GetMapping("/byState/{state}")
    public List<Conges> getCongesByState(@PathVariable String state) {
        return congesService.getCongesByState(state);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Conges> updateConges(@PathVariable Long id, @RequestBody CongesDTO congesDTO) {
        Conges updatedConges = congesService.updateConges(id, congesDTO);
        if (updatedConges != null) {
            return new ResponseEntity<>(updatedConges, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteConges(@PathVariable Long id) {
        congesService.deleteConges(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
