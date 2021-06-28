package com.enigma.pocket.controller;

import com.enigma.pocket.dto.CustomerSearchDto;
import com.enigma.pocket.entity.Customer;
import com.enigma.pocket.format.ResponseMessage;
import com.enigma.pocket.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping("/customer/{id}")
    public Customer getCustomerById(@PathVariable(name = "id") String id) {
        return customerService.findCustomerById(id);
    }

    @GetMapping("/customers")
    public Page<Customer> getAllCustomer(@RequestBody CustomerSearchDto customerSeachForm,
                                         @RequestParam(name = "page") Integer page,
                                         @RequestParam(name = "size") Integer size){
        Pageable pageable = PageRequest.of(page,size);
        return customerService.findCustomer(customerSeachForm, pageable);
    }

    @PostMapping("/customers")
    public void createNewCustomer(@RequestBody Customer customer){
        customerService.createCustomer(customer);
    }

    @PutMapping("/customers/update")
    public void updateCustomer(@RequestBody Customer customer){
        customerService.updateCustomer(customer);
    }
}
