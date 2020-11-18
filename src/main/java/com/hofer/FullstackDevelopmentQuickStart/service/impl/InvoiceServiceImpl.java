package com.hofer.FullstackDevelopmentQuickStart.service.impl;

import com.hofer.FullstackDevelopmentQuickStart.model.request.InvoiceDetailsRequestModel;
import com.hofer.FullstackDevelopmentQuickStart.model.response.Invoice;
import com.hofer.FullstackDevelopmentQuickStart.service.InvoiceService;
import com.hofer.FullstackDevelopmentQuickStart.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvoiceServiceImpl implements InvoiceService {

    Utils utils;

    public InvoiceServiceImpl() {}

    @Autowired
    public InvoiceServiceImpl(Utils utils)
    {
        this.utils =utils;
    }


    @Override
    public Invoice createInvoice(InvoiceDetailsRequestModel invoiceDetails) {
        Invoice returnValue = new Invoice();
        returnValue.setInvoiceDate(invoiceDetails.getInvoiceDate());
        returnValue.setInvoiceNumber(invoiceDetails.getInvoiceNumber());
        returnValue.setValue(invoiceDetails.getValue());
        returnValue.setCustomer(invoiceDetails.getCustomer());
        returnValue.setId(utils.generateId());

        return returnValue;
    }
}
