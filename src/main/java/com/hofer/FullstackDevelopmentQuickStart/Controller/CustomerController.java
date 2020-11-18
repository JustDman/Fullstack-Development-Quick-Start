package com.hofer.FullstackDevelopmentQuickStart.Controller;

import com.hofer.FullstackDevelopmentQuickStart.model.request.CustomerDetailsRequestModel;
import com.hofer.FullstackDevelopmentQuickStart.model.response.Customer;
import com.hofer.FullstackDevelopmentQuickStart.service.CustomerService;
import com.hofer.FullstackDevelopmentQuickStart.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    Utils utils = new Utils();

    @Autowired
    CustomerService customerService;

    @GetMapping
    public List<Customer> getCustomers() {
        return customerService.listAll();
    }

    @GetMapping(path="/{customerId}",
            produces =  {
                    MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_JSON_VALUE
            } )
    public ResponseEntity<Customer> getUser(@PathVariable Long customerId)
    {
        if(customerService.exists(customerId)) {
            return new ResponseEntity<>(customerService.get(customerId), HttpStatus.OK);
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
    public ResponseEntity<Customer> createUser(@Valid @RequestBody CustomerDetailsRequestModel customerDetails)
    {

        Customer returnValue = new Customer();
        returnValue.setId(utils.generateId());
        returnValue.setLastName(customerDetails.getLastName());
        returnValue.setFirstName(customerDetails.getFirstName());

        customerService.save(returnValue);

        return new ResponseEntity<Customer>(returnValue, HttpStatus.OK);
    }

}
