package com.hofer.FullstackDevelopmentQuickStart.model.response;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "RECHNUNG")
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @Column(name = "ID")
    private String id;

    @Column(name = "RECHNUNGSNUMMER")
    private String invoiceNumber;

    @Temporal(TemporalType.DATE)
    @Column(name = "RECHNUNGSDATUM")
    private Date invoiceDate;

    @Column(name = "RECHNUNGSBETRAG")
    private float value;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "KUNDEN_ID")
    private Customer customer;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
