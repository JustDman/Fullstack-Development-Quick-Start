package com.hofer.FullstackDevelopmentQuickStart.model.request;

import com.hofer.FullstackDevelopmentQuickStart.model.response.Customer;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class InvoiceDetailsRequestModel {

    @NotNull(message="Rechnungsnummer darf nicht NULL sein")
    private String invoiceNumber;

    @NotNull(message="Rechnungsdatum darf nicht NULL sein")
    private Date invoiceDate;

    @NotNull(message="Rechnungsbetrag darf nicht NULL sein")
    private float value;

    @NotNull(message="Kunde darf nicht NULL sein")
    private Customer customer;

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