package com.enigma.pocket.controller;

import com.enigma.pocket.entity.Customer;
import com.enigma.pocket.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerRestController {

    @Autowired
    CustomerService customerService;

    @GetMapping("/customer/{id}")
    public Customer getCustomerById(@PathVariable(name = "id") Integer id){
        return customerService.findCustomerById(id);
    }
    @GetMapping("/customers")
    public List<Customer> getAllCustomer(){
        return customerService.findCustomers();
    }
    @PostMapping("/customer")
    public void createNewCustomer(@RequestBody Customer customer){
        customerService.createCustomer(customer);
    }



}
