package com.PFE.Microservice.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import com.PFE.Microservice.Entity.Absence;
import com.PFE.Microservice.DTO.AbsenceDTO;
import com.PFE.Microservice.Services.AbsenceService;

@RestController
@RequestMapping("/absences")
public class AbsenceController {

    @Autowired
    private AbsenceService absenceService;

    @PostMapping
    public Absence createAbsence(@RequestBody AbsenceDTO absenceDTO) {
        return absenceService.saveAbsence(absenceDTO);
    }

    @GetMapping
    public List<Absence> getAllAbsences() {
        return absenceService.getAllAbsences();
    }

    @GetMapping("/{id}")
    public Optional<Absence> getAbsencesById(@PathVariable Long id) {
        return absenceService.getAbsenceById(id);
    }

    @PutMapping("/{id}")
    public Absence updateContact(@PathVariable Long id, @RequestBody AbsenceDTO absencesDTO) {
        return absenceService.updateAbsence(id, absencesDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteContact(@PathVariable Long id) {
        absenceService.deleteAbsence(id);
    }
}
