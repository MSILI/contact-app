package com.contact.service;

import com.contact.entities.Contact;
import com.contact.repositories.ContactRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactServiceImpl implements ContactService {

    private ContactRepository contactRepository;

    public ContactServiceImpl(final ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Override
    public Contact save(Contact contact) {
        if (contactRepository.existsByEmail(contact.getEmail())) {
            throw new RuntimeException("un compte avec l'email " + contact.getEmail() + " existe déjà !");
        }
        if (contactRepository.existsByPhone(contact.getPhone())) {
            throw new RuntimeException("un compte avec le telephone" + contact.getPhone() + " existe déjà !");
        }
        return this.contactRepository.save(contact);
    }

    @Override
    public Contact update(Contact contact) {
        return this.contactRepository.save(contact);
    }

    @Override
    public List<Contact> findAllByFirstNameOrLastName(String query) {
        return this.contactRepository.findAllByFirstNameOrLastNameContainingIgnoreCase(query, query);
    }

    @Override
    public Contact findById(Long id) {
        return this.contactRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("l'utilisateur avec l'id " + id + " est introuvable!"));
    }

    @Override
    public void deleteById(Long id) {
        this.contactRepository.deleteById(id);
    }
}
