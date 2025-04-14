package com.contactmanager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contactmanager.exception.ContactNotFoundException;
import com.contactmanager.model.Contact;
import com.contactmanager.repository.ContactRepository;

@Service
public class ContactService {
	@Autowired
	private ContactRepository repository;

    public List<Contact> getAll() {
        return repository.findAll();
    }

    public Contact getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ContactNotFoundException(id));
    }

    public Contact add(Contact contact) {
        return repository.save(contact);
    }

    public Contact update(Long id, Contact updatedContact) {
        Contact contact = getById(id);
        contact.setName(updatedContact.getName());
        contact.setEmail(updatedContact.getEmail());
        contact.setPhone(updatedContact.getPhone());
        return repository.save(contact);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public List<Contact> searchByName(String name) {
        return repository.findByNameContainingIgnoreCase(name);
    }

    public List<Contact> searchByPhone(String phone) {
        return repository.findByPhoneContaining(phone);
    }
}
