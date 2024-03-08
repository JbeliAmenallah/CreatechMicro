package com.PFE.Microservice.Controller;

import com.PFE.Microservice.DTO.ContactDTO;
import com.PFE.Microservice.Entity.Contact;
import com.PFE.Microservice.Services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/contacts")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @PostMapping
    public Contact createContact(@Valid @RequestBody ContactDTO contactDTO) {
        return contactService.saveContact(contactDTO);
    }

    @GetMapping
    public List<Contact> getAllContacts() {
        return contactService.getAllContacts();
    }

    @GetMapping("/{id}")
    public Optional<Contact> getContactById(@PathVariable Long id) {
        return contactService.getContactById(id);
    }

    @PutMapping("/{id}")
    public Contact updateContact(@PathVariable Long id, @Valid @RequestBody ContactDTO contactDTO) {
        return contactService.updateContact(id, contactDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteContact(@PathVariable Long id) {
        contactService.deleteContact(id);
    }
}
