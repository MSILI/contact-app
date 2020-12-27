package com.contact.repositories;

import com.contact.entities.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {

    boolean existsByPhone(String phone);

    boolean existsByEmail(String email);

    List<Contact> findAllByFirstNameOrLastNameContainingIgnoreCase(String firstName, String lastName);
}
