package com.PFE.Microservice.Controller;

import com.PFE.Microservice.DTO.CotisationDTO;
import com.PFE.Microservice.Entity.Cotisation;
import com.PFE.Microservice.Services.CotisationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cotisations")
public class CotisationController {

    @Autowired
    private CotisationService cotisationService;

    @PostMapping
    public Cotisation createCotisation(@RequestBody CotisationDTO cotisationDTO) {
        return cotisationService.saveCotisation(cotisationDTO);
    }

    @GetMapping
    public List<Cotisation> getAllCotisations() {
        return cotisationService.getAllCotisations();
    }

    @GetMapping("/{id}")
    public Cotisation getCotisationById(@PathVariable Long id) {
        return cotisationService.getCotisationById(id).orElse(null);
    }

    @GetMapping("/byContact/{contactName}")
    public List<Cotisation> getCotisationsByContactName(@PathVariable String contactName) {
        return cotisationService.getCotisationsByContactName(contactName);
    }

    @PutMapping("/{id}")
    public Cotisation updateCotisation(@PathVariable Long id, @RequestBody CotisationDTO cotisationDTO) {
        return cotisationService.updateCotisation(id, cotisationDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteCotisation(@PathVariable Long id) {
        cotisationService.deleteCotisation(id);
    }
}
