package com.hofer.FullstackDevelopmentQuickStart.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity(name = "KUNDE")
public class Customer {

    @Id
    @GenericGenerator(name="native",strategy = "native")
    @Column(name="ID")
    private Long id;

    @Column(name = "NACHNAME")
    private String lastName;

    @Column(name = "VORNAME")
    private String firstName;

    @OneToMany(cascade =  CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "customer")
    @Column(name = "RECHNUNGEN")
    private List<Invoice> invoices;
}
