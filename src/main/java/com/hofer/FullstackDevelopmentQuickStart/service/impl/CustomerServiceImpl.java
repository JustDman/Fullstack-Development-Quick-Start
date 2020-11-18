package com.hofer.FullstackDevelopmentQuickStart.service.impl;

import com.hofer.FullstackDevelopmentQuickStart.model.response.Customer;
import com.hofer.FullstackDevelopmentQuickStart.repository.CustomerRepository;
import com.hofer.FullstackDevelopmentQuickStart.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository repo;


    public CustomerServiceImpl() {
    }

    @Override
    public List<Customer> listAll() {
        return repo.findAll();
    }

    @Override
    public void save(Customer customer) {
        repo.save(customer);
    }

    @Override
    public Customer get(Long id) {
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


