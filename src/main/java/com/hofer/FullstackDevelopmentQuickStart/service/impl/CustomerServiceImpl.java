package com.hofer.FullstackDevelopmentQuickStart.service.impl;

import com.hofer.FullstackDevelopmentQuickStart.model.request.CustomerDetailsRequestModel;
import com.hofer.FullstackDevelopmentQuickStart.model.response.Customer;
import com.hofer.FullstackDevelopmentQuickStart.service.CustomerService;
import com.hofer.FullstackDevelopmentQuickStart.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    Utils utils;

    public CustomerServiceImpl() {}

    @Autowired
    public CustomerServiceImpl(Utils utils)
    {
        this.utils =utils;
    }

    @Override
    public Customer createCustomer(CustomerDetailsRequestModel customerDetails) {
        Customer returnValue = new Customer();
        returnValue.setFirstName(customerDetails.getFirstName());
        returnValue.setLastName(customerDetails.getLastName());
        returnValue.setInvoices(customerDetails.getInvoices());
        returnValue.setId(utils.generateId());

        return returnValue;
    }
}
