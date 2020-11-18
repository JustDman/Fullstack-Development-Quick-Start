package com.hofer.FullstackDevelopmentQuickStart.model;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "RECHNUNG")
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @Column(name = "ID")
    private Long id;

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
}
