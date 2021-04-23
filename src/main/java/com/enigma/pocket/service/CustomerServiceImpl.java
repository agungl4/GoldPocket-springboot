package com.enigma.pocket.service;

import com.enigma.pocket.entity.Customer;
import com.enigma.pocket.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.OffsetDateTime;
import java.util.List;
@Service
public class CustomerServiceImpl implements CustomerService{
//    private final String notFoundMsg = "cust with id %s not found";

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Customer findCustomerById(String id) {
        return null;
    }

    @Override
    public List<Customer> findCustomers(String firstName, String email, Pageable pageable) {
        return null;
    }

    @Override
    public void createCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void updateCustomer(Customer customer) {
//        validatePresent(customer.getId());
        customerRepository.save(customer);
    }

//    private boolean isCustomerPresent(Customer customer) {
//        return customerRepository.findById(customer.getId()).isPresent();
//    }
//
//    private void validatePresent(String id){
//        if(!customerRepository.findById(id).isPresent()){
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format(notFoundMsg,id));
//        }
//    }

    @Override
    public void removeCustomer(Integer id) {

    }
}
