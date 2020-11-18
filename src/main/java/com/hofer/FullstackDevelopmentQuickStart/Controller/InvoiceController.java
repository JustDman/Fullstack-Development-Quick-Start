package com.hofer.FullstackDevelopmentQuickStart.Controller;

import com.hofer.FullstackDevelopmentQuickStart.model.request.InvoiceDetailsRequestModel;
import com.hofer.FullstackDevelopmentQuickStart.model.response.Invoice;
import com.hofer.FullstackDevelopmentQuickStart.service.CustomerService;
import com.hofer.FullstackDevelopmentQuickStart.service.InvoiceService;
import com.hofer.FullstackDevelopmentQuickStart.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/invoice")
public class InvoiceController {

    Utils utils = new Utils();

    @Autowired
    InvoiceService invoiceService;

    @Autowired
    CustomerService customerService;

    @GetMapping
    public List<Invoice> getInvoices() {
        return invoiceService.listAll();
    }

    @GetMapping(path="/{invoiceId}",
            produces =  {
                    MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_JSON_VALUE
            } )
    public ResponseEntity<Invoice> GetInvoice(@PathVariable Long invoiceId)
    {
        if (invoiceService.exists(invoiceId)) {
            Invoice temp = invoiceService.get(invoiceId);
            return new ResponseEntity<>(temp, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping(
            consumes =  {
                    MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_JSON_VALUE
            },
            produces =  {
                    MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_JSON_VALUE
            }  )
    public ResponseEntity<Invoice> createUser(@Valid @RequestBody InvoiceDetailsRequestModel invoiceDetails)
    {

        Invoice returnValue = new Invoice();
        returnValue.setId(utils.generateId());
        returnValue.setValue(invoiceDetails.getValue());
        returnValue.setInvoiceNumber(invoiceDetails.getInvoiceNumber());
        returnValue.setInvoiceDate(new Date());
        returnValue.setCustomer(customerService.get(invoiceDetails.getCustomer()));

        invoiceService.save(returnValue);

        return new ResponseEntity<>(returnValue, HttpStatus.OK);
    }

    @PutMapping(path="/{invoiceId}", consumes =  {
            MediaType.APPLICATION_XML_VALUE,
            MediaType.APPLICATION_JSON_VALUE
    },
            produces =  {
                    MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_JSON_VALUE
            }  )
    public ResponseEntity<Void> updateInvoice(@PathVariable Long invoiceId, @Valid @RequestBody InvoiceDetailsRequestModel invoiceDetails)
    {
        Invoice storedInvoiceDetails = invoiceService.get(invoiceId);
        storedInvoiceDetails.setValue(invoiceDetails.getValue());
        storedInvoiceDetails.setInvoiceNumber(invoiceDetails.getInvoiceNumber());

        invoiceService.save(storedInvoiceDetails);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(path="/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id)
    {
        invoiceService.delete(id);

        return ResponseEntity.noContent().build();
    }

}
