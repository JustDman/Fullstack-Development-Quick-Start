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
    public ResponseEntity<Customer> GetCustomer(@PathVariable Long customerId)
    {
        if (customerService.exists(customerId)) {
            Customer temp = customerService.get(customerId);
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
    public ResponseEntity<Customer> createUser(@Valid @RequestBody CustomerDetailsRequestModel customerDetails)
    {

        Customer returnValue = new Customer();
        returnValue.setId(utils.generateId());
        returnValue.setLastName(customerDetails.getLastName());
        returnValue.setFirstName(customerDetails.getFirstName());

        customerService.save(returnValue);

        return new ResponseEntity<>(returnValue, HttpStatus.OK);
    }

    @PutMapping(path="/{customerId}", consumes =  {
            MediaType.APPLICATION_XML_VALUE,
            MediaType.APPLICATION_JSON_VALUE
    },
            produces =  {
                    MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_JSON_VALUE
            }  )
    public ResponseEntity<Void> updateCustomer(@PathVariable Long customerId, @Valid @RequestBody CustomerDetailsRequestModel customerDetails)
    {
        Customer storedCustomerDetails = customerService.get(customerId);
        storedCustomerDetails.setFirstName(customerDetails.getFirstName());
        storedCustomerDetails.setLastName(customerDetails.getLastName());

        customerService.save(storedCustomerDetails);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(path="/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id)
    {
        customerService.delete(id);

        return ResponseEntity.noContent().build();
    }

}
