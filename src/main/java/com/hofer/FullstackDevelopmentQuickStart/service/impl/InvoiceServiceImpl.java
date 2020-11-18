package com.hofer.FullstackDevelopmentQuickStart.service.impl;

import com.hofer.FullstackDevelopmentQuickStart.model.response.Invoice;
import com.hofer.FullstackDevelopmentQuickStart.repository.InvoiceRepository;
import com.hofer.FullstackDevelopmentQuickStart.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceServiceImpl implements InvoiceService {

    @Autowired
    InvoiceRepository repo;


    public InvoiceServiceImpl() {
    }

    @Override
    public List<Invoice> listAll() {
        return repo.findAll();
    }

    @Override
    public void save(Invoice invoice) {
        repo.save(invoice);
    }

    @Override
    public Invoice get(Long id) {
        return repo.findById(id).get();
    }

    public boolean exists(Long id) {
        return repo.existsById(id);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }
}


