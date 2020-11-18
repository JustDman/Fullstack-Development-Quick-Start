package com.hofer.FullstackDevelopmentQuickStart.service;

import com.hofer.FullstackDevelopmentQuickStart.model.request.InvoiceDetailsRequestModel;
import com.hofer.FullstackDevelopmentQuickStart.model.response.Invoice;

public interface InvoiceService {

    Invoice createInvoice(InvoiceDetailsRequestModel invoiceDetails);
}
