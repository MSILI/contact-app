package com.contact.service;

import com.contact.entities.Contact;

import java.util.List;

public interface ContactService {

    Contact save(Contact contact);

    Contact update(Contact contact);

    List<Contact> findAllByFirstNameOrLastName(String query);

    Contact findById(Long id);

    void deleteById(Long id);
}
