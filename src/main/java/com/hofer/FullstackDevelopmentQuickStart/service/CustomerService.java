package com.hofer.FullstackDevelopmentQuickStart.service;

import com.hofer.FullstackDevelopmentQuickStart.model.response.Customer;

import java.util.List;

public interface CustomerService {


    List<Customer> listAll();

    void save(Customer customer);

    Customer get(Long id);

    boolean exists(Long id);

    void delete(Long id);
}
