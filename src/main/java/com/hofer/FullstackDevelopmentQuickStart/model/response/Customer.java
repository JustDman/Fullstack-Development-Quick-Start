package com.hofer.FullstackDevelopmentQuickStart.model.response;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public List<Invoice> getInvoices() {
        return invoices;
    }

    public void setInvoices(List<Invoice> invoices) {
        this.invoices = invoices;
    }
}
