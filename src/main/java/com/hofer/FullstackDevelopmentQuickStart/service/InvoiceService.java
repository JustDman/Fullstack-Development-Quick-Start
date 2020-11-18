package com.hofer.FullstackDevelopmentQuickStart.service;

import com.hofer.FullstackDevelopmentQuickStart.model.response.Invoice;

import java.util.List;

public interface InvoiceService {


    List<Invoice> listAll();

    void save(Invoice invoice);

    Invoice get(Long id);

    boolean exists(Long id);

    void delete(Long id);
}
