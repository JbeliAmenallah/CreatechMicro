package com.PFE.Microservice.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.PFE.Microservice.Repository.ContactRepository;
import com.PFE.Microservice.DTO.ContactDTO;
import com.PFE.Microservice.Entity.Contact;
import java.util.List;
import java.util.Optional;

@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    public Contact saveContact(ContactDTO contactDTO) {
        Contact contact = new Contact();
        contact.setName(contactDTO.getName());
        contact.setPhone(contactDTO.getPhone());
        contact.setMailAddress(contactDTO.getMailAddress());
        contact.setAge(contactDTO.getAge());
        contact.setDegree(contactDTO.getDegree());

        return contactRepository.save(contact);
    }

    public List<Contact> getAllContacts() {
        return (List<Contact>) contactRepository.findAll();
    }

    public Optional<Contact> getContactById(Long id) {
        return contactRepository.findById(id);
    }

    public Contact updateContact(Long id, ContactDTO contactDTO) {
        Optional<Contact> optionalContact = contactRepository.findById(id);

        if (optionalContact.isPresent()) {
            Contact existingContact = optionalContact.get();
            existingContact.setName(contactDTO.getName());
            existingContact.setPhone(contactDTO.getPhone());
            existingContact.setMailAddress(contactDTO.getMailAddress());
            existingContact.setAge(contactDTO.getAge());
            existingContact.setDegree(contactDTO.getDegree());

            return contactRepository.save(existingContact);
        } else {
            // Handle not found scenario
            return null;
        }
    }

    public void deleteContact(Long id) {
        contactRepository.deleteById(id);
    }
}
