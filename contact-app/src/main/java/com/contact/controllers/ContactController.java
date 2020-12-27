package com.contact.controllers;

import com.contact.entities.Contact;
import com.contact.service.ContactService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api/contacts")
public class ContactController {

    private ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @PostMapping
    ResponseEntity<Contact> save(@RequestBody Contact contact) throws URISyntaxException {
        return ResponseEntity
                .created(new URI("/api/contacts/" + contact.getId()))
                .body(contactService.save(contact));
    }

    @PutMapping
    ResponseEntity<Contact> update(@RequestBody Contact contact) {
        return ResponseEntity
                .ok()
                .body(contactService.update(contact));
    }

    @GetMapping
    ResponseEntity<List<Contact>> findAllByFirstNameOrLastName(@RequestParam(name = "q", defaultValue = "") String query) {
        return ResponseEntity
                .ok()
                .body(contactService.findAllByFirstNameOrLastName(query));
    }

    @GetMapping("/{id}")
    ResponseEntity<Contact> findById(@PathVariable("id") Long id) {
        return ResponseEntity
                .ok()
                .body(contactService.findById(id));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteById(@PathVariable("id") Long id) {
        contactService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
