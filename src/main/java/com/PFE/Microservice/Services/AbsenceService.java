package com.PFE.Microservice.Services;

import java.sql.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.PFE.Microservice.Entity.Absence;
import com.PFE.Microservice.DTO.AbsenceDTO;
import com.PFE.Microservice.Repository.AbsenceRepository;
import com.PFE.Microservice.Repository.ContactRepository;
import java.util.List;
import java.util.Optional;

@Service
public class AbsenceService {

    @Autowired
    private AbsenceRepository absenceRepository;

    @Autowired
    private ContactRepository contactRepository;

    public Absence saveAbsence(AbsenceDTO absenceDTO) {
        Absence absence = new Absence();
        Date sqlDate = new Date(absenceDTO.getDateOfAbsence().getTime());
        absence.setDateOfAbsence(sqlDate);
        absence.setReason(absenceDTO.getReason());

        // Fetch the associated Contact and set it
        contactRepository.findById(absenceDTO.getContactId()).ifPresent(absence::setContact);

        return absenceRepository.save(absence);
    }

    public List<Absence> getAllAbsences() {
        return absenceRepository.findAll();
    }

    public Optional<Absence> getAbsenceById(Long id) {
        return absenceRepository.findById(id);
    }

    public Absence updateAbsence(Long id, AbsenceDTO absenceDTO) {
        Optional<Absence> optionalAbsence = absenceRepository.findById(id);

        if (optionalAbsence.isPresent()) {
            Absence existingAbsence = optionalAbsence.get();
            existingAbsence.setDateOfAbsence(new Date(absenceDTO.getDateOfAbsence().getTime()));
            existingAbsence.setReason(absenceDTO.getReason());

            // Fetch the associated Contact and set it
            contactRepository.findById(absenceDTO.getContactId()).ifPresent(existingAbsence::setContact);

            return absenceRepository.save(existingAbsence);
        } else {
            // Handle not found scenario
            return null;
        }
    }

    public void deleteAbsence(Long id) {
        absenceRepository.deleteById(id);
    }
}
