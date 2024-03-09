package com.PFE.Microservice.Controller;

import com.PFE.Microservice.Entity.Autorisation;
import com.PFE.Microservice.DTO.AutorisationDTO;
import com.PFE.Microservice.Services.AutorisationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autorisations")
public class AutorisationController {

    @Autowired
    private AutorisationService autorisationService;

    @PostMapping
    public Autorisation createAutorisation(@RequestBody AutorisationDTO autorisationDTO) {
        return autorisationService.saveAutorisation(autorisationDTO);
    }

    @GetMapping
    public List<Autorisation> getAllAutorisations() {
        return autorisationService.getAllAutorisations();
    }

    @GetMapping("/{id}")
    public Autorisation getAutorisationById(@PathVariable Long id) {
        return autorisationService.getAutorisationById(id).orElse(null);
    }

    @GetMapping("/byContact/{contactName}")
    public List<Autorisation> getAutorisationsByContactName(@PathVariable String contactName) {
        return autorisationService.getAutorisationsByContactName(contactName);
    }

    @PutMapping("/{id}")
    public Autorisation updateAutorisation(@PathVariable Long id, @RequestBody AutorisationDTO autorisationDTO) {
        return autorisationService.updateAutorisation(id, autorisationDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteAutorisation(@PathVariable Long id) {
        autorisationService.deleteAutorisation(id);
    }
}
