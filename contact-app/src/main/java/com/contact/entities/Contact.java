package com.contact.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "contacts")
@Data
public class Contact {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String address;
    private String phone;
    private String email;
}
