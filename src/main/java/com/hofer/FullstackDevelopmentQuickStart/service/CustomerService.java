package com.hofer.FullstackDevelopmentQuickStart.service;

import com.hofer.FullstackDevelopmentQuickStart.model.request.CustomerDetailsRequestModel;
import com.hofer.FullstackDevelopmentQuickStart.model.response.Customer;

public interface CustomerService {

    Customer createCustomer(CustomerDetailsRequestModel customerDetails);
}
