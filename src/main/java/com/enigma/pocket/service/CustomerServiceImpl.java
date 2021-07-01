package com.enigma.pocket.service;

import com.enigma.pocket.dto.CustomerSearchDto;
import com.enigma.pocket.entity.Customer;
import com.enigma.pocket.exception.CustomerNotFoundException;
import com.enigma.pocket.repository.CustomerRepository;
import com.enigma.pocket.specification.CustomerSpesification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;


import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{

    private final String notFoundMessage = "Customer with id:%s Not FOund";

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Customer findCustomerById(String id) {
        validatePresent(id);
        Customer customer = customerRepository.findById(id).get();
        return customer;
    }



    private void validatePresent(String id) {
        if (!customerRepository.findById(id).isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format(notFoundMessage, id));
        }
    }

    @Override
    public Page<Customer> findCustomer(CustomerSearchDto customerSearchFoam, Pageable pageable) {
        return customerRepository.findAll(CustomerSpesification.findCustomer(customerSearchFoam),pageable);
    }

    @Override
    public void createCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void updateCustomer(Customer customer) {
        validatePresent(customer.getId());
        customerRepository.save(customer);

    }

    @Override
    public void deleteCustomer() {

    }

    @Override
    public Customer login(String username, String password) {
        return customerRepository.findCustomerByUsernameAndPassword(username, password);
    }
}
